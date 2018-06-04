package br.com.reflector.api.util;

public class ReflectorUtil {
	
	private ReflectorUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static Boolean isContainsSuperclass(Class<?> clazz) {
		return clazz.getSuperclass() != null && isSuperclassNotObject(clazz);
	}
	
	private static Boolean isSuperclassNotObject(Class<?> clazz) {
		return !clazz.getSuperclass().isAssignableFrom(Object.class);
	}
	
	
	
}
