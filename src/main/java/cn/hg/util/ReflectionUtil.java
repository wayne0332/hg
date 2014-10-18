package cn.hg.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionUtil {
	public static Field makeAccessibility(Field field){
		try {
			field.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			return field;
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException("修改字段访问属性出错", e);
		}
	}
}
