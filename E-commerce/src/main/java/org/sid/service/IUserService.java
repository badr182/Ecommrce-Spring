package org.sid.service;

import org.sid.entites.User;
import org.sid.validation.EmailExistsException;
import org.sid.web.dto.UserDto;

public interface IUserService {
	
	// throw EmailExistException 
	User registerNewAccount(UserDto accountDto) throws EmailExistsException;	
}
