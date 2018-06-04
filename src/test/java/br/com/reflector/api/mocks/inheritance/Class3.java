package br.com.reflector.api.mocks.inheritance;

public class Class3 extends Class2 {

	@Override
	public void print() {
		System.out.println("print from Class3");
	}
	
	public void printClass3() {
		System.out.println("Class3");
	}
	
}
