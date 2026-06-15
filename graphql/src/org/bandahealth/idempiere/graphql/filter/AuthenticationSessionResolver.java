package org.bandahealth.idempiere.graphql.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.model.AuthenticationCookie;
import org.bandahealth.idempiere.graphql.utils.AuthenticationUtil;
import org.compiere.model.MSession;
import org.compiere.util.Env;
import org.compiere.util.Util;

import javax.servlet.http.Cookie;

/**
 * Derives the authentication state from a request's session cookie, if any.
 */
class AuthenticationSessionResolver {

	private AuthenticationSessionResolver() {
	}

	static AuthenticationSessionState resolve(BandaServletRequestWrapper request) {
		Cookie authenticationCookie = AuthenticationCookie.getAuthenticationCookie(request);
		if (authenticationCookie == null) {
			return AuthenticationSessionState.NONE;
		}
		try {
			AuthenticationUtil.validate(authenticationCookie.getValue(), Env.getCtx());
			if (Util.isEmpty(Env.getContext(Env.getCtx(), Env.AD_USER_ID))) {
				return AuthenticationSessionState.NONE;
			}
			if (Util.isEmpty(Env.getContext(Env.getCtx(), Env.AD_ROLE_ID))) {
				return AuthenticationSessionState.PARTIAL;
			}
			MSession session = MSession.get(Env.getCtx());
			if (session == null || session.isProcessed()) {
				return AuthenticationSessionState.PARTIAL;
			}
			return AuthenticationSessionState.FULL;
		} catch (JWTVerificationException | AdempiereException ex) {
			return AuthenticationSessionState.NONE;
		} catch (Exception ex) {
			return AuthenticationSessionState.NONE;
		}
	}
}
