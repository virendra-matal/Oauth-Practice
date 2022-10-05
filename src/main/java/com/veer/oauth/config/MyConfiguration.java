package com.veer.oauth.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.veer.oauth.config.oauth2.CustomeOauth2UserService;
import com.veer.oauth.config.oauth2.Oauth2LoginSuccessHandler;
import com.veer.oauth.config.oauth2.OnLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter{
	

	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private CustomeOauth2UserService customeOauth2UserService;
	
	@Autowired
	private Oauth2LoginSuccessHandler oauth2LoginSuccessHandler;
	
	@Autowired
	private LoginAuthenticationFailuireHandler loginAuthenticationFeluireHandler;
	
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	private OnLogoutSuccessHandler onLogoutSuccessHandler;
	
	
	@Bean
	public UserDetailsServiceImpl getUserDetailsServise() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(getUserDetailsServise());
		authenticationProvider.setPasswordEncoder(getEncoder());
		return authenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth .authenticationProvider(getAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/dashboard").hasRole("USER").antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/oauth/**","/login","/register").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/dologin")
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(successHandler)
			.failureHandler(loginAuthenticationFeluireHandler)
		.and()
		.oauth2Login()
			.loginPage("/login")
			.userInfoEndpoint()
				.userService(customeOauth2UserService)
			.and()
			.successHandler(oauth2LoginSuccessHandler)
			//.and()
			//.logout().logoutSuccessUrl("/login").logoutSuccessHandler(onLogoutSuccessHandler).permitAll()
		.and()
		.rememberMe().tokenValiditySeconds(7 * 24 * 60 * 60).key("mySecret").userDetailsService(getUserDetailsServise())
		.and()
		.logout().logoutSuccessUrl("/login").logoutSuccessHandler(logoutSuccessHandler).permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
		
		
	}
	
	
}
