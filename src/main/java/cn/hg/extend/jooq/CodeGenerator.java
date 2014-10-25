package cn.hg.extend.jooq;

import cn.hg.constant.ConstantGenerator;
import com.google.common.collect.Lists;
import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.*;
import org.jooq.util.mysql.MySQLDatabase;

public class CodeGenerator {
	public static void main(String args[]) throws Exception {
		Configuration configuration = new Configuration();
		initJdbc(configuration);
		initGenerator(configuration);
		GenerationTool.main(configuration);
	}

	private static void initGenerator(Configuration configuration) {
		Generator generator = new Generator();
		generator.setName(CustomJavaGenerator.class.getName());
		initDatabase(generator);
		initTarget(generator);
		configuration.setGenerator(generator);
	}

	private static void initGenerate(Generator generator) {
		Generate generate = new Generate();
		generate.setPojos(true);
		generator.setGenerate(generate);
	}

	private static void initTarget(Generator generator) {
		Target target = new Target();
		target.setDirectory("/Users/Jason/work/hg/src/main/java");
		target.setPackageName("cn.hg.jooq");
		generator.setTarget(target);
	}

	private static void initDatabase(Generator generator) {
		Database database = new Database();
		database.setName(MySQLDatabase.class.getName());
		database.setInputSchema("hhgg853478196");
		database.setOutputSchema("hg");
		CustomType customType = new CustomType();
		customType.setName(ConstantGenerator.Constant.class.getSimpleName());
		customType.setType("cn.hg.constant.ConstantGenerator.Constant");
		customType.setConverter(ConstantConverter.class.getName());
		database.setCustomTypes(Lists.newArrayList(customType));
		ForcedType forcedType = new ForcedType();
		forcedType.setName(ConstantGenerator.Constant.class.getSimpleName());
		forcedType.setTypes("tinyint");
		database.setForcedTypes(Lists.newArrayList(forcedType));
		generator.setDatabase(database);
	}

	private static void initJdbc(Configuration configuration) {
		Jdbc jdbc = new Jdbc();
		jdbc.setDriver("com.mysql.jdbc.Driver");
		jdbc.setUrl("jdbc:mysql://localhost:3306/hhgg853478196");
		jdbc.setUser("root");
		jdbc.setPassword("root");
		configuration.setJdbc(jdbc);
	}
}
