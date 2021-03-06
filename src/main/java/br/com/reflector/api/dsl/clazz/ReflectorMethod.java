package br.com.reflector.api.dsl.clazz;

import java.lang.reflect.Method;

import br.com.reflector.api.core.Const;
import br.com.reflector.api.exception.ReflectorException;

/**
 * Class method
 *  
 * @author renato
 *
 */
public class ReflectorMethod {

	private Method method;

	/**
	 * Create a class from methods by name
	 * @param clazz
	 * @param name
	 * @param parameterTypes
	 */
	protected ReflectorMethod(final Class<?> clazz, final String name) {
		try {
			this.method = clazz.getDeclaredMethod(name);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ReflectorException("No such method " + name, e);
		}
	}

	/**
	 * Create a class from methods by name and parameters
	 * @param clazz
	 * @param name
	 * @param parameterTypes
	 */
	protected ReflectorMethod(final Class<?> clazz, final String name, Class<?>... parameterTypes) {
		try {
			this.method = clazz.getDeclaredMethod(name, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ReflectorException(Const.MSG_ERROR_COULD_NOT_INVOKE_METHOD + name, e);
		}
	}

	/**
	 * Return name from method
	 * @return
	 */
	public String getName() {
		return this.method.getName();
	}

}
