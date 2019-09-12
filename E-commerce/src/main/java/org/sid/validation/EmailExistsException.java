package org.sid.validation;

@SuppressWarnings("serail")
public class EmailExistsException extends Throwable{
	
	public EmailExistsException(final String message) {
		super(message);
	}
	
}
