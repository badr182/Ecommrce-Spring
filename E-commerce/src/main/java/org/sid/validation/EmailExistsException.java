package org.sid.validation;

@SuppressWarnings("serail")
public class EmailExistsException extends RuntimeException{

	// 		
    private static final long serialVersionUID = 5861310537366287163L;

	public EmailExistsException(final String message) {
		super(message);
	}
	
}
