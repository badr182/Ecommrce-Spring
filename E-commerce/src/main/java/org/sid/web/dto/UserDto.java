package org.sid.web.dto;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// import org.sid.validation.FieldMatch;
import org.sid.validation.PasswordMatches;
// import org.sid.validation.UniqueEmail;
import org.sid.validation.ValidEmail;
// import org.sid.validation.ValidUsername;



//@FieldMatch(first = "userName", second = "email", message = "The password fields must match")
//@PasswordMatches
public class UserDto {

	//@ValidUsername
	@NotNull
	@NotEmpty
	private String userName;
	
	@NotNull
	@NotEmpty
    @Size(min = 4, message = "Password should be more than 4 characters")
	private String password;
	
	// @NotNull
	// @NotEmpty
	private String matchingPassword;
    

	
	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
