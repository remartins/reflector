package br.com.reflector.api.exception;

public class ReflectorException extends RuntimeException {

	private static final long serialVersionUID = 855094367253613318L;

	public ReflectorException(String message) {
		super(message);
	}

	public ReflectorException(String message, Throwable cause) {
		super(message, cause);
	}

}
