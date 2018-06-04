package br.com.reflector.api.dsl.object;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.reflector.api.core.Config;
import br.com.reflector.api.util.ReflectorUtil;

public class ReflectorObject {

	private Config config;
	private Object obj;

	private List<ReflectorMethod> methodsClass;
	private List<ReflectorMethod> methodsClassAndSuperClass;

	public ReflectorObject(Object obj) {
		this.obj = obj;
		this.config = Config.getInstance();
		this.methodsClass = new ArrayList<ReflectorMethod>();
		this.methodsClassAndSuperClass = new ArrayList<ReflectorMethod>();
	}

	/**
	 * Get method by name without params
	 * 
	 * @param name
	 * @return
	 */
	public ReflectorMethod method(String name) {
		return new ReflectorMethod(obj, name);
	}

	/**
	 * Get method by name with params
	 * 
	 * @param name
	 * @param parameterTypes
	 * @return
	 */
	public ReflectorMethod method(String name, Class<?>... parameterTypes) {
		return new ReflectorMethod(obj, name, parameterTypes);
	}

	/**
	 * Get methods by name
	 * @param name
	 * @return
	 */
	public List<ReflectorMethod> methodsByName(String name) {
		return methods().stream().filter(reflectMethod -> name.equals(reflectMethod.getName()))
				.collect(Collectors.toList());
	}

	/**
	 * Get methods from class
	 * 
	 * @return List<ReflectorMethod>
	 */
	public List<ReflectorMethod> methods() {
		if (this.methodsClass.isEmpty()) {
			addMethods(this.obj.getClass());
		}
		return this.methodsClass;
	}

	/**
	 * Get methods form class and superclass, except Object
	 * 
	 * @return List<ReflectorMethod>
	 */
	public List<ReflectorMethod> methodsAll() {
		if (this.methodsClassAndSuperClass.isEmpty()) {
			addMethodsSuperClass(this.obj.getClass());
		}
		return this.methodsClassAndSuperClass;
	}

	/**
	 * Add methods from clazz to list methods
	 * @param clazz
	 * @param methods
	 */
	private void addMethods(Class<?> clazz, List<ReflectorMethod> methods) {
		for (Method m : clazz.getDeclaredMethods()) {
			if (!config.getIgnoreMethod().contains(m.getName())) {
				methods.add(new ReflectorMethod(m, obj));
			}
		}
	}

	private void addMethods(Class<?> clazz) {
		addMethods(clazz, this.methodsClass);
	}

	private void addMethodsSuperClass(Class<?> clazz) {
		addMethods(clazz, this.methodsClassAndSuperClass);
		if (ReflectorUtil.isContainsSuperclass(clazz)) {
			addMethodsSuperClass(clazz.getSuperclass());
		}
	}

}
