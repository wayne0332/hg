package cn.hg.util;

import org.apache.commons.lang3.StringUtils;
import org.jooq.util.DefaultGeneratorStrategy;
import org.jooq.util.Definition;
import org.jooq.util.SchemaDefinition;

/**
 * TODO
 *
 * @author linjiangsheng
 * @created 2014/6/12
 */
public class JooqGeneratorStrategy extends DefaultGeneratorStrategy
{

	public static final String TABLE_PREFIX = "t_";
	public static final String SCHEMA_SUFFIX = "Schema";

	@Override
	public String getJavaIdentifier(Definition definition)
	{
		return custom(definition, super.getJavaIdentifier(definition), new CustomName()
		{
			@Override
			public String deal(String oriName)
			{
				return StringUtils.removeStartIgnoreCase(oriName, TABLE_PREFIX.toUpperCase());
			}
		}, new CustomName()
		{
			@Override
			public String deal(String oriName)
			{
				return oriName + "_" + SCHEMA_SUFFIX.toUpperCase();
			}
		});
	}

	@Override
	public String getJavaClassName(Definition definition, Mode mode)
	{
		return custom(definition, super.getJavaClassName(definition, mode), new CustomName()
		{
			@Override
			public String deal(String oriName)
			{
				return StringUtils.removeStartIgnoreCase(oriName, TABLE_PREFIX.substring(0, 1).toUpperCase());
			}
		}, new CustomName()
		{
			@Override
			public String deal(String oriName)
			{
				return oriName + SCHEMA_SUFFIX;
			}
		});
	}

	private String custom(Definition definition, String className, CustomName isTable, CustomName isSchema)
	{
		String tableName = definition.getOutputName();
		if (!StringUtils.isEmpty(tableName) && StringUtils.startsWith(tableName, TABLE_PREFIX))
		{
			return isTable.deal(className);
		}
		else
		{
			if (definition instanceof SchemaDefinition)
			{
				return isSchema.deal(className);
			}
		}
		return className;
	}

	private interface CustomName
	{
		String deal(String oriName);
	}
}
