package br.com.reflector.api.dsl;


import br.com.reflector.api.core.Config;
import br.com.reflector.api.dsl.clazz.ReflectorClass;

public class Reflector {
	
	
	private Reflector() {
	}
	
	public static Config config() {
		return Config.getInstance();
	}

	public static ReflectorClass on(Class<?> clazz) {
		return new ReflectorClass(clazz);
	}
	
//	public static Object on(Object obj) {
//		return null;
//	}

}
