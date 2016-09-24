package br.com.reflector.api.dsl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.reflector.api.dsl.clazz.ReflectorMethod;
import br.com.reflector.api.mocks.inheritance.Duck;

public class ReflectorTestMethod {

	@Test
	public void testMethods() {
		List<ReflectorMethod> list = Reflector.on(Duck.class).methods();
		Assert.assertTrue(list.size() == 1);
	}

	@Test
	public void testMethodsAll() {
		List<ReflectorMethod> list = Reflector.on(Duck.class).methodsAll();
		Assert.assertTrue(list.size() == 2);
	}

}
