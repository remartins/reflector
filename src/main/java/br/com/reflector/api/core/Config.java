package br.com.reflector.api.core;

import java.util.ArrayList;
import java.util.List;

public class Config {

	private static Config instance;

	private List<String> ignoreClass;
	private List<String> ignoreMethod;

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	private Config() {
		this.ignoreClass = new ArrayList<>();
		this.ignoreMethod = new ArrayList<>();
		this.restoreDefault();
	}
	
	public void restoreDefault() {
		this.ignoreClass.clear();;
		this.ignoreMethod.clear();;

		addDefaultIgnoreClass();
		addDefaultIgnoreMethods();
	}
	

	public void addIgnoreClass(String className) {
		this.ignoreClass.add(className);
	}

	public void addIgnoreMethod(String methodName) {
		this.ignoreMethod.add(methodName);
	}

	public List<String> getIgnoreMethod() {
		return ignoreMethod;
	}

	private void addDefaultIgnoreClass() {
		addIgnoreClass(Object.class.getName());
	}
	
	private void addDefaultIgnoreMethods() {
		addIgnoreMethod(Const.METHOD_IGNORE_ECLEMMA_COVERAGE);
	}

}
