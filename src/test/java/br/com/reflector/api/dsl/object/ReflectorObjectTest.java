package br.com.reflector.api.dsl.object;

import org.junit.Test;

import br.com.reflector.api.dsl.Reflector;
import br.com.reflector.api.mocks.General;
import br.com.reflector.api.mocks.inheritance.Class3;

public class ReflectorObjectTest {

	@Test
	public void invokeMethodByName() {
		Reflector.on(new General()).methodsByName("printValue").get(0).invoke("simple test");
	}
	
	@Test
	public void invokeMethodByParamsType() {
		Reflector.on(new General()).method("printValue", String.class).invoke("second test");
	}
	
	@Test
	public void allMethods() {
		for (ReflectorMethod m : Reflector.on(new Class3()).methodsAll()) {
			System.out.println(m.getName());
		}
	}
	
}
