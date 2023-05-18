package br.com.icaro.api.services.exceptions;

@SuppressWarnings("serial")
public class ObjectNotFoundException extends RuntimeException {

	
	public ObjectNotFoundException(String message) {
		super(message);
	}

}
