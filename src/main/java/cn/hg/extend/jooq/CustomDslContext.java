package cn.hg.extend.jooq;

import org.jooq.Configuration;
import org.jooq.impl.DefaultDSLContext;

public class CustomDslContext extends DefaultDSLContext {
	public CustomDslContext(Configuration configuration) {
		super(configuration);
		configuration.set(new CustomRecordMapperProvider(configuration));
	}
}
