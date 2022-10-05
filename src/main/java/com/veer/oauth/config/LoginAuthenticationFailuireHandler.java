package com.veer.oauth.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginAuthenticationFailuireHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		System.out.println("login failed due to : " + exception.getMessage());
		List<String> message = List.of(exception.getMessage());
		System.out.println(request.getContextPath() + "/login");
		request.setAttribute("message", message);
		request.setAttribute("color","danger");
		request.getRequestDispatcher(request.getContextPath() + "/login").forward(request, response);
	}

}
