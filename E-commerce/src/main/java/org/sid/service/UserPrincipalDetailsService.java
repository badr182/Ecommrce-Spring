package org.sid.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sid.dao.UserRepository;
import org.sid.entites.Privilege;
import org.sid.entites.Role;
import org.sid.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//        User user = this.userRepository.findByUsername(s);
//        UserPrincipal userPrincipal = new UserPrincipal(user);
//		  return userPrincipal;

//		final String ip = getClientIP();
//		if (loginAttemptService.isBlocked(ip)) {
//			throw new RuntimeException("blocked");
//		}

		try {
			final User user = userRepository.findByEmail(email);
			if (user == null) {
				throw new UsernameNotFoundException("No user found with username: " + email);
			}

			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					user.isEnabled(), true, true, true, getAuthorities(user.getRoles()));

		} catch (final Exception e) {

			throw new RuntimeException(e);

		}

	}

	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {

		return getGrantedAuthorities(getPrivileges(roles));

	}

	private List<String> getPrivileges(Collection<Role> roles) {

		List<String> privileges = new ArrayList<>();
		List<Privilege> collection = new ArrayList<>();
		for (Role role : roles) {
			collection.addAll(role.getPrivileges());
		}
		for (Privilege item : collection) {
			privileges.add(item.getName());
		}
		return privileges;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}

//	private final String getClientIP() {
//        final String xfHeader = request.getHeader("X-Forwarded-For");
//        if (xfHeader == null) {
//            return request.getRemoteAddr();
//        }
//        return xfHeader.split(",")[0];
//    }

}
