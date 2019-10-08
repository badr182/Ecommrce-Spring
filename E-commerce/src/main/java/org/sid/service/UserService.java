package org.sid.service;

import java.util.ArrayList;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.sid.dao.UserRepository;
import org.sid.entites.User;
import org.sid.validation.EmailExistsException;
import org.sid.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	
	@Autowired
	PasswordEncoder passwordencoder ;

	@Autowired
	private UserRepository repository;

	@Transactional
	@Override
	public User registerNewAccount(UserDto accountDto) throws EmailExistsException {

		if (emailExist(accountDto.getEmail())) {
			// System.out.println("Exception here about existing email !! ");
			// UserAlreadyExist
			throw new EmailExistsException("There is an account with that email address " + accountDto.getEmail());

		}

		User user = new User();
		user.setUsername(accountDto.getUserName());
		user.setPassword( passwordencoder.encode(accountDto.getPassword()) ); // use the encoder 
		user.setEmail(accountDto.getEmail());
		user.setActive(false);
		// roles
		ArrayList role = new ArrayList();
		role.add("ROLE_USER");
		user.setRoles( role ); //  Arrays.asList("ROLE_USER")
		return repository.save(user);
	}

	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

}
