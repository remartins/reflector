package br.com.reflector.api.util;

public class ReflectorUtil {

	public static Boolean isContainsSuperclass(Class<?> clazz) {
		return clazz.getSuperclass() != null && isSuperclassNotObject(clazz);
	}
	
	private static Boolean isSuperclassNotObject(Class<?> clazz) {
		return !clazz.getSuperclass().getName().equals(Object.class.getName());
	}
	
	
	
}
