package br.com.reflector.api.dsl;

import org.junit.Assert;
import org.junit.Test;

import br.com.reflector.api.exception.ReflectorException;
import br.com.reflector.api.mocks.General;

public class ReflectorTest {

	@Test
	public void testMethodWithoutParams() {
		Assert.assertNotNull(Reflector.on(General.class).method("getIntegerValue2"));
	}
	
	@Test (expected = ReflectorException.class)
	public void testMethodNotSuch() {
		Reflector.on(General.class).method("notExists");
	}
	
//	@Test (expected = ReflectorException.class)
//	public void testMethodNotExists() {
//		Reflector.on(General.class).method("powSquared");
//	}
}
