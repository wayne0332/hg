package cn.hg.extend.jooq;

import cn.hg.util.ReflectionUtil;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.tools.StringUtils;
import org.jooq.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.jooq.tools.StringUtils.defaultIfBlank;
import static org.jooq.tools.StringUtils.defaultString;

public class CustomJavaGenerator extends JavaGenerator {
	private Logger log = LoggerFactory.getLogger(CustomJavaGenerator.class);

	private static final String NO_FURTHER_INSTANCES_ALLOWED = "No further instances allowed";

	private Database database = null;

	@Override
	protected void generateTable(SchemaDefinition schema, TableDefinition table) {
		java.lang.reflect.Field field = ReflectionUtils.findField(JavaGenerator.class, "database");
		ReflectionUtil.makeAccessibility(field);
		try {
			database = (Database) field.get(this);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}

		UniqueKeyDefinition primaryKey = table.getPrimaryKey();

		final boolean updatable = generateRelations() && primaryKey != null;
		final String className = getStrategy().getJavaClassName(table);
		final String fullClassName = getStrategy().getFullJavaClassName(table);
		final String fullTableId = getStrategy().getFullJavaIdentifier(table);
		final String recordType = getStrategy().getFullJavaClassName(table, GeneratorStrategy.Mode.RECORD);
		final List<String> interfaces = getStrategy().getJavaClassImplements(table, GeneratorStrategy.Mode.DEFAULT);
		final String comment = defaultString(table.getComment());

		log.info("Generating table", getStrategy().getFileName(table) +
				" [input=" + table.getInputName() +
				", output=" + table.getOutputName() +
				", pk=" + (primaryKey != null ? primaryKey.getName() : "N/A") +
				"]");

		JavaWriter out = new JavaWriter(getStrategy().getFile(table));
		printPackage(out, table);
		printClassJavadoc(out, table);

		out.println("public class %s extends %s<%s>[[before= implements ][%s]] {", className, TableImpl.class, recordType, interfaces);
		out.printSerial();
		printSingletonInstance(out, table);
		printRecordTypeMethod(out, table);

		for (ColumnDefinition column : table.getColumns()) {
			final String columnType = getJavaType(column.getType());
			final String columnTypeRef = getJavaTypeReference(column.getDatabase(), column.getType());
			final String columnId = getStrategy().getJavaIdentifier(column);
			final String columnName = column.getName();
			final String columnComment = StringUtils.defaultString(column.getComment());
			final String columnConverterType = column.getType().getConverter();

			String isStatic = generateInstanceFields() ? "" : "static ";
			String tableRef = generateInstanceFields() ? "this" : getStrategy().getJavaIdentifier(table);

			out.tab(1).javadoc("The column <code>%s</code>.%s", column.getQualifiedOutputName(), defaultIfBlank(" " + columnComment, ""));

			if (columnConverterType != null) {
				String recordJavaType = Byte.class.getName() + ".class";
				String enumClass = "cn.hg.constant." + className + org.apache.commons.lang3.StringUtils.capitalize(columnName) + ".class";
				out.tab(1).println("public %sfinal %s<%s, %s> %s = createField(\"%s\", %s, %s, \"%s\", new %s(%s, %s));",
						isStatic, TableField.class, recordType, columnType, columnId, columnName, columnTypeRef, tableRef, escapeString(columnComment), columnConverterType, recordJavaType, enumClass);
			} else {
				out.tab(1).println("public %sfinal %s<%s, %s> %s = createField(\"%s\", %s, %s, \"%s\");",
						isStatic, TableField.class, recordType, columnType, columnId, columnName, columnTypeRef, tableRef, escapeString(columnComment));
			}
		}

		// [#1255] With instance fields, the table constructor may
		// be public, as tables are no longer singletons
		if (generateInstanceFields()) {
			out.tab(1).javadoc("Create a <code>%s</code> table reference", table.getQualifiedOutputName());
			out.tab(1).println("public %s() {", className);
		} else {
			out.tab(1).javadoc(NO_FURTHER_INSTANCES_ALLOWED);
			out.tab(1).println("private %s() {", className);
		}

		out.tab(2).println("this(\"%s\", null);", table.getOutputName());
		out.tab(1).println("}");

		// [#117] With instance fields, it makes sense to create a
		// type-safe table alias
		// [#1255] With instance fields, the table constructor may
		// be public, as tables are no longer singletons
		final String schemaId = getStrategy().getFullJavaIdentifier(schema);

		if (generateInstanceFields()) {
			out.tab(1).javadoc("Create an aliased <code>%s</code> table reference", table.getQualifiedOutputName());
			out.tab(1).println("public %s(%s alias) {", className, String.class);
			out.tab(2).println("this(alias, %s);", fullTableId);
			out.tab(1).println("}");
		}

		out.println();
		out.tab(1).println("private %s(%s alias, %s<%s> aliased) {", className, String.class, Table.class, recordType);
		out.tab(2).println("this(alias, aliased, null);");
		out.tab(1).println("}");

		out.println();
		out.tab(1).println("private %s(%s alias, %s<%s> aliased, %s<?>[] parameters) {", className, String.class, Table.class, recordType, Field.class);
		out.tab(2).println("super(alias, %s, aliased, parameters, \"%s\");", schemaId, escapeString(comment));
		out.tab(1).println("}");

		// Add primary / unique / foreign key information
		if (generateRelations()) {
			IdentityDefinition identity = table.getIdentity();

			// The identity column
			if (identity != null) {
				final String identityType = getJavaType(identity.getColumn().getType());
				final String identityFullId = getStrategy().getFullJavaIdentifier(identity);

				out.tab(1).overrideInherit();
				out.tab(1).println("public %s<%s, %s> getIdentity() {", Identity.class, recordType, identityType);
				out.tab(2).println("return %s;", identityFullId);
				out.tab(1).println("}");
			}

			// The primary / main unique key
			if (primaryKey != null) {
				final String keyFullId = getStrategy().getFullJavaIdentifier(primaryKey);

				out.tab(1).overrideInherit();
				out.tab(1).println("public %s<%s> getPrimaryKey() {", UniqueKey.class, recordType);
				out.tab(2).println("return %s;", keyFullId);
				out.tab(1).println("}");
			}

			// The remaining unique keys
			List<UniqueKeyDefinition> uniqueKeys = table.getUniqueKeys();
			if (uniqueKeys.size() > 0) {
				final List<String> keyFullIds = getStrategy().getFullJavaIdentifiers(uniqueKeys);

				out.tab(1).overrideInherit();
				out.tab(1).println("public %s<%s<%s>> getKeys() {", List.class, UniqueKey.class, recordType);
				out.tab(2).println("return %s.<%s<%s>>asList([[%s]]);", Arrays.class, UniqueKey.class, recordType, keyFullIds);
				out.tab(1).println("}");
			}

			// Foreign keys
			List<ForeignKeyDefinition> foreignKeys = table.getForeignKeys();
			if (foreignKeys.size() > 0) {
				final List<String> keyFullIds = getStrategy().getFullJavaIdentifiers(foreignKeys);

				out.tab(1).overrideInherit();
				out.tab(1).println("public %s<%s<%s, ?>> getReferences() {", List.class, ForeignKey.class, recordType);
				out.tab(2).println("return %s.<%s<%s, ?>>asList([[%s]]);", Arrays.class, ForeignKey.class, recordType, keyFullIds);
				out.tab(1).println("}");
			}
		}

		// [#1596] Updatable tables can provide fields for optimistic locking
		// if properly configured
		if (updatable) {
			patternLoop:
			for (String pattern : database.getRecordVersionFields()) {
				Pattern p = Pattern.compile(pattern, Pattern.COMMENTS);

				for (ColumnDefinition column : table.getColumns()) {
					if ((p.matcher(column.getName()).matches() ||
							p.matcher(column.getQualifiedName()).matches())) {

						final String columnType = getJavaType(column.getType());
						final String columnId = getStrategy().getFullJavaIdentifier(column);

						out.tab(1).overrideInherit();
						out.tab(1).println("public %s<%s, %s> getRecordVersion() {", TableField.class, recordType, columnType);
						out.tab(2).println("return %s;", columnId);
						out.tab(1).println("}");

						// Avoid generating this method twice
						break patternLoop;
					}
				}
			}

			timestampLoop:
			for (String pattern : database.getRecordTimestampFields()) {
				Pattern p = Pattern.compile(pattern, Pattern.COMMENTS);

				for (ColumnDefinition column : table.getColumns()) {
					if ((p.matcher(column.getName()).matches() ||
							p.matcher(column.getQualifiedName()).matches())) {

						final String columnType = getJavaType(column.getType());
						final String columnId = getStrategy().getFullJavaIdentifier(column);

						out.tab(1).overrideInherit();
						out.tab(1).println("public %s<%s, %s> getRecordTimestamp() {", TableField.class, recordType, columnType);
						out.tab(2).println("return %s;", columnId);
						out.tab(1).println("}");

						// Avoid generating this method twice
						break timestampLoop;
					}
				}
			}
		}

		// [#117] With instance fields, it makes sense to create a
		// type-safe table alias
		if (generateInstanceFields()) {
			out.tab(1).overrideInherit();
			out.tab(1).println("public %s as(%s alias) {", fullClassName, String.class);

			if (table.isTableValuedFunction())
				out.tab(2).println("return new %s(alias, this, parameters);", fullClassName);
			else
				out.tab(2).println("return new %s(alias, this);", fullClassName);

			out.tab(1).println("}");
		}

		// [#2921] With instance fields, tables can be renamed.
		if (generateInstanceFields()) {
			out.tab(1).javadoc("Rename this table");
			out.tab(1).println("public %s rename(%s name) {", fullClassName, String.class);

			if (table.isTableValuedFunction())
				out.tab(2).println("return new %s(name, null, parameters);", fullClassName);
			else
				out.tab(2).println("return new %s(name, null);", fullClassName);

			out.tab(1).println("}");
		}

		// [#1070] Table-valued functions should generate an additional set of call() methods
		if (table.isTableValuedFunction()) {
			for (boolean parametersAsField : new boolean[]{false, true}) {

				// Don't overload no-args call() methods
				if (parametersAsField && table.getParameters().size() == 0)
					break;

				out.tab(1).javadoc("Call this table-valued function");
				out.tab(1).print("public %s call(", fullClassName);
				printParameterDeclarations(out, table, parametersAsField);
				out.println(") {");

				out.tab(2).print("return new %s(getName(), null, new %s[] { ", fullClassName, Field.class);
				String separator = "";
				for (ParameterDefinition parameter : table.getParameters()) {
					out.print(separator);

					if (parametersAsField) {
						out.print("%s", getStrategy().getJavaMemberName(parameter));
					} else {
						out.print("%s.val(%s)", DSL.class, getStrategy().getJavaMemberName(parameter));
					}

					separator = ", ";
				}
				out.println(" });");

				out.tab(1).println("}");
			}
		}

		generateTableClassFooter(table, out);
		out.println("}");
		out.close();
	}

	private String escapeString(String comment) {

		// [#3450] Escape also the escape sequence, among other things that break Java strings.
		return comment.replace("\\", "\\\\")
				.replace("\"", "\\\"")
				.replace("\n", "\\n")
				.replace("\r", "\\r");
	}

	private void printParameterDeclarations(JavaWriter out, TableDefinition function, boolean parametersAsField) {
		String sep1 = "";
		for (ParameterDefinition parameter : function.getParameters()) {
			out.print(sep1);

			if (parametersAsField) {
				out.print("%s<%s>", Field.class, getExtendsNumberType(parameter.getType()));
			} else {
				out.print(getNumberType(parameter.getType()));
			}

			out.print(" %s", getStrategy().getJavaMemberName(parameter));
			sep1 = ", ";
		}
	}
}
