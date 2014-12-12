package cn.hg.extend.jooq;

import cn.hg.constant.ConstantGenerator;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.*;
import org.jooq.util.mysql.MySQLDatabase;

import java.io.FileInputStream;
import java.util.Properties;

import static cn.hg.Constant.SCHEMA_NAME;

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
		target.setDirectory("/Users/Jesse/git/hg/src/main/java");
		target.setPackageName("cn.hg.jooq");
		generator.setTarget(target);
	}

	private static void initDatabase(Generator generator) {
		Database database = new Database();
		database.setName(MySQLDatabase.class.getName());
		database.setInputSchema(SCHEMA_NAME);
		database.setOutputSchema("hg");
		CustomType customType = new CustomType();
		customType.setName(ConstantGenerator.Constant.class.getSimpleName());
		customType.setType(StringUtils.replace(ConstantGenerator.Constant.class.getName(), "$", "."));
		customType.setConverter(ConstantConverter.class.getName());
		database.setCustomTypes(Lists.newArrayList(customType));
		ForcedType forcedType = new ForcedType();
		forcedType.setName(ConstantGenerator.Constant.class.getSimpleName());
		forcedType.setTypes("tinyint");
		database.setForcedTypes(Lists.newArrayList(forcedType));
		generator.setDatabase(database);
	}

	private static void initJdbc(Configuration configuration) throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream("database.properties"));
		Jdbc jdbc = new Jdbc();
		jdbc.setDriver(properties.getProperty("database.driverClassName"));
		jdbc.setUrl(properties.getProperty("database.url"));
		jdbc.setUser(properties.getProperty("database.username"));
		jdbc.setPassword(properties.getProperty("database.password"));
		configuration.setJdbc(jdbc);
	}
}
