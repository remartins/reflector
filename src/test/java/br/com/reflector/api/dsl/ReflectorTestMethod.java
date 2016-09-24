package br.com.reflector.api.dsl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.reflector.api.dsl.clazz.ReflectorMethod;
import br.com.reflector.api.mocks.inheritance.Duck;

public class ReflectorTestMethod {
	
	private final String METHOD_IGNORE_DUCK_SWIM = "swim";
	
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
	
	@Test
	public void testReflectorConfigIgnoreMethod() {
		
		Reflector.config().addIgnoreMethod(METHOD_IGNORE_DUCK_SWIM);
		
		List<ReflectorMethod> list = Reflector.on(Duck.class).methods();
		System.out.println(list.size());
		
		List<ReflectorMethod> list2 = Reflector.on(Duck.class).methods();
		System.out.println(list2.size());

		Assert.assertTrue(list.size() == 0 && list2.size() == 0);
	}


	@Test
	public void testReflectorConfigIgnoreMethodRestoreDefault() {
		
		Reflector.config().addIgnoreMethod(METHOD_IGNORE_DUCK_SWIM);
		
		List<ReflectorMethod> list = Reflector.on(Duck.class).methods();
		System.out.println(list.size());
		
		Reflector.config().restoreDefault();
		
		List<ReflectorMethod> list2 = Reflector.on(Duck.class).methods();
		System.out.println(list2.size());

		Assert.assertTrue(list.size() == 0 && list2.size() == 1);
	}


}
