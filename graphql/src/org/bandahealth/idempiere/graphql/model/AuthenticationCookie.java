package org.bandahealth.idempiere.graphql.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationCookie extends Cookie {
	public static final String COOKIE_NAME = "GQL_SESSION";

	public AuthenticationCookie(String jwtToken) {
		super(COOKIE_NAME, jwtToken);
		setHttpOnly(true);
		setSecure(true);
	}

	public static Cookie getAuthenticationCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null || cookies.length < 1) {
			return null;
		}

		for (Cookie cookie : cookies) {
			if ((COOKIE_NAME).equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}
}
