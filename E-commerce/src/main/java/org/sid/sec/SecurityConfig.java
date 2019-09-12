package org.sid.sec;

//import org.sid.service.AppAuthProvider;
//import org.sid.service.UserService;
//import org.sid.sec.AuthentificationLogoutSuccessHandler;

// import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.access.AccessDeniedHandler;
// import org.springframework.security.web.authentication.AuthenticationFailureHandler;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
// import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//@Autowired
	//UserService userDetailsService;

	// @Autowired
	// private AccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.userDetailsService(userDetailsService);		
        auth.inMemoryAuthentication()
        .withUser("badr").password( passwordEncoder().encode("badr") ).roles("USER");
        /*.and()
        .withUser("badrUser2").password( passwordEncoder().encode("badr") ).roles("USER")
        .and()
        .withUser("badradmin").password( passwordEncoder().encode("badr") ).roles("ADMIN");*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * 
		 * http.csrf() .disable() .exceptionHandling() .authenticationEntryPoint(new
		 * Http403ForbiddenEntryPoint() {}) .and()
		 * .authenticationProvider(getProvider()) .formLogin()
		 * .loginProcessingUrl("/login") .successHandler((AuthenticationSuccessHandler)
		 * new AuthentificationLogoutSuccessHandler()) // cast .failureHandler(new
		 * SimpleUrlAuthenticationFailureHandler() ) .and() .logout()
		 * .logoutUrl("/logout") .logoutSuccessUrl("/") // new
		 * AuthentificationLogoutSuccessHandler() .invalidateHttpSession(true) .and()
		 * .authorizeRequests() .antMatchers("/login").permitAll()
		 * .antMatchers("/logout").permitAll()
		 * .antMatchers("/user").authenticated().anyRequest().permitAll();
		 * 
		 */
//		http.formLogin().loginPage("/login");		
//		http.authorizeRequests().antMatchers("/home").hasRole("USER");
//		http.authorizeRequests().antMatchers("/home").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
//		http.exceptionHandling().accessDeniedPage("/403");
		
		http.csrf().disable();		
		http.authorizeRequests().antMatchers("/home").hasRole("USER");
		http.formLogin().loginPage("/login");
		http.logout().logoutUrl("/logout");
		
//		  http
//          .csrf().disable() 
//          .authorizeRequests()
//          .antMatchers("/home").hasRole("USER")
//          .antMatchers("/admin/**").hasRole("ADMIN")
//          //.antMatchers("/anonymous*").anonymous()
//          .antMatchers("/login*").permitAll()
//          //.anyRequest().authenticated()
//          .and()
//          .formLogin()
//          .loginPage("/login")
//          .loginProcessingUrl("/perform_login")
//          .defaultSuccessUrl("/homepage.html", true)
//          //.failureUrl("/login.html?error=true")
//          //.failureHandler(authenticationFailureHandler())
//          .and()
//          .logout()
//          .logoutUrl("/perform_logout")
//          .deleteCookies("JSESSIONID");
          //.logoutSuccessHandler(logoutSuccessHandler());

	}
	
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new CustomAuthenticationFailureHandler();
//    }
    
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//	@Bean
//	public AuthenticationProvider getProvider() {
//		AppAuthProvider provider = new AppAuthProvider();
//		provider.setUserDetailsService(userDetailsService);
//		return provider;
//	}
}
