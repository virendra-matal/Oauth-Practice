package com.veer.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "myrestservice";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID);
	}

	@Override public void configure(HttpSecurity http) throws Exception { // TODO
		http
		.authorizeRequests()
		.antMatchers("/dashboard/**").hasRole("USER")
		.antMatchers("/hello/**").hasRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.httpBasic();
	}

}
