package com.binson.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	
	
	/*
	 * for all paths 
	 * 
	 * 
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		//permitAll allows all path accessible without any authentication
		//http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
		
		//denyAll allows all path accessible with a starting authentication page
		http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
	}
	*
	*
	*
	*
	*/
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((requests) ->
				requests.requestMatchers("/home").permitAll().
				requestMatchers("/holidays").permitAll().
				requestMatchers("/contact").permitAll().
				requestMatchers("/saveMsg").permitAll().
				requestMatchers("/courses").permitAll().
				requestMatchers("/about").permitAll().
				requestMatchers("/assets/**").permitAll()
				);
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		
		return http.build();
	}
	
}
