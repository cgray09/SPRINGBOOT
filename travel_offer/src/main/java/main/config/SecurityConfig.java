package main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// "WebSecurityConfigurerAdapter" bc dont want to override all of the methods from the super class

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/login")
				.permitAll()
			.antMatchers("/**")
				.authenticated()
			.and()
				.formLogin()
				.defaultSuccessUrl("/")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/")
				.permitAll();
		
		http.csrf().disable();	// so we can use a REST api
	}
	
}
