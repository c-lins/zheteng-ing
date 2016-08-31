package org.lins.hystrix.exception;

public class RemoteServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RemoteServiceException(String message){
		super(message);
	}
}
