package cn.hg.constant;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class ConstantGenerator<T extends Enum & ConstantGenerator.Constant> {
	private final Class<T> constant;
	private final HashMap<Integer, T> indexConstantMap = Maps.newHashMap();
	private final HashMap<String, T> nameConstantMap = Maps.newHashMap();
	public static final Map<Class, ConstantGenerator> GENERATOR_OF_CONSTANT_CLASS = Maps.newHashMap();

	public static <E extends Enum & ConstantGenerator.Constant> ConstantGenerator<E> create(Class<E> constant) {
		ConstantGenerator<E> generator = new ConstantGenerator<>(constant);
		GENERATOR_OF_CONSTANT_CLASS.put(constant, generator);
		return generator;
	}

	private ConstantGenerator(Class<T> constant) {
		this.constant = constant;
		for (T t : constant.getEnumConstants()) {
			indexConstantMap.put(t.getIndex(), t);
			nameConstantMap.put(t.getName(), t);
		}
	}

	public T getByIndex(Integer index) {
		return checkExist(indexConstantMap.get(checkNotNull(index)), "index", index);
	}

	public T getByName(String name) {
		return checkExist(nameConstantMap.get(checkNotNull(name)), "name", name);
	}

	public Integer getIndex(String name) {
		return getByName(name).getIndex();
	}

	public String getName(Integer index) {
		return getByIndex(index).getName();
	}

	private T checkExist(T t, String description, Object value) {
		if (t == null) {
			throw new IllegalArgumentException(constant.getSimpleName() + "没有" + description + "为" + value + "的枚举");
		}
		return t;
	}

	private <C> C checkNotNull(C reference) {
		if (reference == null) {
			throw new NullPointerException();
		}
		return reference;
	}

	public static interface Constant {
		int getIndex();

		String getName();
	}
}
