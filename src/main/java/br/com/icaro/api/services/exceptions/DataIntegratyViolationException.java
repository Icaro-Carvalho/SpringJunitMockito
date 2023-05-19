package br.com.icaro.api.services.exceptions;

@SuppressWarnings("serial")
public class DataIntegratyViolationException extends RuntimeException {


	public DataIntegratyViolationException(String message) {
		super(message);
	}

}