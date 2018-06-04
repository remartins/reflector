package br.com.reflector.api.dsl.object;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.reflector.api.exception.ReflectorException;

/**
 * Class method
 *  
 * @author renato
 *
 */
public class ReflectorMethod {

	private Object obj;
	private Method method;
	
	
	protected ReflectorMethod(Method method, Object obj) {
		this.method = method;
		this.obj = obj;
	}

	/**
	 * Create a class from methods by name
	 * @param clazz
	 * @param name
	 * @param parameterTypes
	 */
	protected ReflectorMethod(Object obj, final String name) {
		try {
			this.obj = obj;
			this.method = obj.getClass().getDeclaredMethod(name);
		} catch (NoSuchMethodException e) {
			throw new ReflectorException("No such method " + name, e.getCause());
		} catch (SecurityException e) {
			throw new ReflectorException("Could not invoke method " + name, e.getCause());
		}
	}

	/**
	 * Create a class from methods by name and parameters
	 * @param clazz
	 * @param name
	 * @param parameterTypes
	 */
	protected ReflectorMethod(Object obj, final String name, Class<?>... parameterTypes) {
		try {
			this.obj = obj;
			this.method = obj.getClass().getDeclaredMethod(name, parameterTypes);
		} catch (NoSuchMethodException e) {
			throw new ReflectorException("Could not invoke method " + name, e.getCause());
		} catch (SecurityException e) {
			throw new ReflectorException("Could not invoke method " + name, e.getCause());
		}
	}

	/**
	 * Return name from method
	 * @return
	 */
	public String getName() {
		return this.method.getName();
	}
	
	public void invoke(Object... args) {
		try {
			this.method.setAccessible(true);
			this.method.invoke(this.obj, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
