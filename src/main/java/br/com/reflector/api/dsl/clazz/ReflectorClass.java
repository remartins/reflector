package br.com.reflector.api.dsl.clazz;

import java.util.ArrayList;
import java.util.List;

import br.com.reflector.api.util.ReflectorUtil;

/**
 * @author Renato Martins
 * 
 *
 */
public class ReflectorClass {

	private Class<?> clazz;
	private List<ReflectorMethod> methods;

	public ReflectorClass(Class<?> clazz) {
		this.clazz = clazz;
		this.methods = new ArrayList<ReflectorMethod>();
	}

	public ReflectorMethod method(String name) {
		return new ReflectorMethod(clazz, name);
	}

	/**
	 * Get methods from class
	 * @return List<ReflectorMethod>
	 */
	public List<ReflectorMethod> methods() {
		this.addMethods(clazz);
		return getMethods();
	}

	/**
	 * Get methods form class and superclass, except Object
	 * @return List<ReflectorMethod>
	 */
	public List<ReflectorMethod> methodsAll() {
		this.addMethodsAll(clazz);
		return getMethods();
	}

	private void addMethods(Class<?> clazzParam) {

		for (java.lang.reflect.Method m : clazzParam.getDeclaredMethods()) {
			addMethod(new ReflectorMethod(m.getDeclaringClass(), m.getName()));
		}

	}

	private void addMethodsAll(Class<?> clazzParam) {

		if (ReflectorUtil.isContainsSuperclass(clazzParam)) {
			this.addMethods(clazzParam.getSuperclass());
		}

		this.addMethods(clazzParam);
	}

	private void addMethod(ReflectorMethod m) {
		this.getMethods().add(m);

	}

	private List<ReflectorMethod> getMethods() {
		return this.methods;
	}

}
