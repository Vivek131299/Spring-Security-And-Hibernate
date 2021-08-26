package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("MANAGER"))
			.withUser(users.username("susan").password("test123").roles("ADMIN"));
		// We can give any role names.
	}

	
	// For Configuring security of web paths in application, login, logout, etc.
	// We will use/override this method to use our custom login page.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()  // To restrict access based on the HttpServletRequest.
				.anyRequest().authenticated() // Any request to the app must be authenticated (i.e. logged in).
			.and()
			.formLogin()	// We are customizing the form login process.
				.loginPage("/showMyLoginPage")  // Show our custom form at the Request Mapping("/showMyLoginPage"). We need controller mapping to this.
				.loginProcessingUrl("/authenticateTheUser") // Login form should POST data to this URL for processing(check user is and password). We don't need controller mapping to this. Spring handles it.
				.permitAll();	// Allow everyone to see login page. No need to be logged in.
	}
	
}
