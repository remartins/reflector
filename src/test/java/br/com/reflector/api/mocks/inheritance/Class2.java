package br.com.reflector.api.mocks.inheritance;

public class Class2 extends Class1 {

	@Override
	public void print() {
		System.out.println("print from Class2");
	}
	
	public void printClass2() {
		System.out.println("Class2");
	}
	
}
