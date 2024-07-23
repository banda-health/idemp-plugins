package org.bandahealth.idempiere.graphql.model;

import org.bandahealth.idempiere.graphql.utils.StringUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationCookie extends Cookie {
	public static final String COOKIE_NAME = "GQL_SESSION";
	private static final String DISABLE_GRAPHQL_SECURE_COOKIE_FLAG = System.getenv("DISABLE_GRAPHQL_SECURE_COOKIE_FLAG");

	public AuthenticationCookie(String jwtToken) {
		super(COOKIE_NAME, jwtToken);
		setHttpOnly(true);
		if (StringUtil.isNullOrEmpty(DISABLE_GRAPHQL_SECURE_COOKIE_FLAG) ||
				!DISABLE_GRAPHQL_SECURE_COOKIE_FLAG.equalsIgnoreCase("true")) {
			setSecure(true);
		}
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
