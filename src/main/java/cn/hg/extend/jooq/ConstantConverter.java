package cn.hg.extend.jooq;

import cn.hg.constant.ConstantGenerator;
import org.jooq.Converter;

public class ConstantConverter<T, U extends Enum<U> & ConstantGenerator.Constant> implements Converter<T, U> {
	private final Class<U> constantClass;
	private final Class<T> fromClass;

	public ConstantConverter(Class<T> fromClass, Class<U> constantClass) {
		this.constantClass = constantClass;
		this.fromClass = fromClass;
		try {
			Class.forName(constantClass.getName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public U from(T databaseObject) {
		if (databaseObject == null) {
			return null;
		}
		return (U)ConstantGenerator.GENERATOR_OF_CONSTANT_CLASS.get(constantClass).getByIndex(Byte.valueOf((Byte)databaseObject).intValue());
	}

	@Override
	public T to(U userObject) {
		if (userObject == null) {
			return null;
		}
		return (T) Byte.valueOf(Integer.valueOf(userObject.getIndex()).byteValue());
	}

	@Override
	public Class<T> fromType() {
		return fromClass;
	}

	@Override
	public Class<U> toType() {
		return constantClass;
	}
}
