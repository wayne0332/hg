package cn.hg.extend.jooq;

import cn.hg.constant.ConstantGenerator;
import cn.hg.util.ReflectionUtil;
import com.google.common.collect.Maps;
import org.jooq.*;
import org.jooq.exception.MappingException;
import org.jooq.impl.DefaultRecordMapper;
import org.jooq.impl.DefaultRecordMapperProvider;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Map;

/**
 * 在record转换pojo时提供自动设置枚举类型的支持
 * 注意:枚举类型必须实现{@link cn.hg.constant.ConstantGenerator.Constant}接口,并生成相应{@link cn.hg.constant.ConstantGenerator}字段
 * 具体参考{@link cn.hg.constant.ManagerType}
 * pojo映射按照field名字进行对应,setter/getter不会造成影响,不支持非基础类型(即自定义类型)和JPA注解
 * pojo格式参考{@link cn.hg.pojo.Manager}
 */
public class CustomRecordMapperProvider implements RecordMapperProvider, Serializable {
	private final Configuration configuration;

	public CustomRecordMapperProvider(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public final <R extends Record, E> RecordMapper<R, E> provide(final RecordType<R> recordType, final Class<? extends E> pojoType) {
		RecordMapper<R, E> defaultProvide = new DefaultRecordMapperProviderWrapper(configuration).provide(recordType, pojoType);
		swapRecordMapper(defaultProvide, recordType, pojoType);
		return defaultProvide;
	}

	private <R extends Record, E> void swapRecordMapper(RecordMapper<R, E> defaultProvide, RecordType<R> recordType, final Class<? extends E> pojoType) {
		java.lang.reflect.Field defaultDelegate = ReflectionUtils.findField(DefaultRecordMapper.class, "delegate", RecordMapper.class);
		try {
			final Object defaultRecordMapper = ReflectionUtil.makeAccessibility(defaultDelegate).get(defaultProvide);
			if (defaultRecordMapper.getClass().getSimpleName().equals("MutablePOJOMapper")) {
				final Map<Field, java.lang.reflect.Field> pojoFieldByRecordField = generateRecordFieldAndPojoFieldMapping(recordType, pojoType);
				final Constructor<? extends E> pojoConstructor = pojoType.getDeclaredConstructor();

				defaultDelegate.set(defaultProvide, new RecordMapper<R, E>() {
					public E map(R record) {
						return customRecordToPojoMap(record);
					}

					private E customRecordToPojoMap(R record) {
						try {
							E newPojo = pojoConstructor.newInstance();
							for (Map.Entry<Field, java.lang.reflect.Field> fieldFieldEntry : pojoFieldByRecordField.entrySet()) {
								Class pojoFieldType = fieldFieldEntry.getValue().getType();
								Object pojoFieldValue = null;
								if (pojoFieldType.getSuperclass().equals(Enum.class)) {
									Class.forName(pojoFieldType.getName());
									Integer constantIndex = record.<Integer>getValue(fieldFieldEntry.getKey(), Integer.class);
									pojoFieldValue = ConstantGenerator.GENERATOR_OF_CONSTANT_CLASS.get(pojoFieldType).getByIndex(constantIndex);
								} else {
									pojoFieldValue = record.getValue(fieldFieldEntry.getKey());
								}
								fieldFieldEntry.getValue().set(newPojo, pojoFieldValue);
							}
							return newPojo;
						} catch (Exception e) {
							throw new MappingException("An error ocurred when mapping record to " + pojoType, e);
						}
					}
				});
			}
		} catch (Exception e) {
			throw new RuntimeException("pojo配置出错", e);
		}
	}

	private <R extends Record, E> Map<Field, java.lang.reflect.Field> generateRecordFieldAndPojoFieldMapping(RecordType<R> recordType, Class<? extends E> pojoType) {
		Map<Field, java.lang.reflect.Field> pojoFieldByRecordField = Maps.newHashMap();
		Field<?>[] recordFields = recordType.fields();
		java.lang.reflect.Field[] pojoFields = pojoType.getDeclaredFields();
		for (Field<?> recordField : recordFields) {
			for (java.lang.reflect.Field pojoField : pojoFields) {
				if (recordField.getName().equals(pojoField.getName())) {
					pojoFieldByRecordField.put(recordField, pojoField);
				}
			}
		}
		return pojoFieldByRecordField;
	}

	public class DefaultRecordMapperProviderWrapper extends DefaultRecordMapperProvider {
		public DefaultRecordMapperProviderWrapper(Configuration configuration) {
			super(configuration);
		}
	}
}
