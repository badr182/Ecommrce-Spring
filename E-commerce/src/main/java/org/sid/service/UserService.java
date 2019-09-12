package org.sid.service;

import javax.transaction.Transactional;

import org.sid.dao.UserRepository;
import org.sid.entites.User;
import org.sid.validation.EmailExistsException;
import org.sid.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// service 
@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository repository ;
	
	@Transactional
	@Override
	public User registerNewAccount( UserDto accountDto )
		throws EmailExistsException{
		
		if(  emailExist(accountDto.getEmail())  ){
			throw new EmailExistsException(
					"There is an account with that email address "+ accountDto.getEmail()); 
		}		
		User user = new User();
		user.setUsername(accountDto.getFirstName());
		user.setPassword(accountDto.getPassword());
		user.setEmail(accountDto.getEmail());
		// roles 
		// user.setRoles( Arrays.asList("ROLE_USER") )
		
		return repository.save(user) ;
	}
	
	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if( user != null  ) {
			return true ;
		}
		return false;
	}
	
	
	
}
