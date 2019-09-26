package org.bandahealth.idempiere.rest.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.glassfish.jersey.internal.util.Base64;
import org.idempiere.adinterface.CompiereService;
import org.apache.cxf.jaxrs.ext.MessageContext;

/**
 * Basic Authentication
 * 
 * @author andrew
 *
 */
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	private static final String COMPIERE_SERVICE = "CompiereService";
	@Context
	protected MessageContext context; // rest context

	@Context
	private ResourceInfo resourceInfo;
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final String UNATHORIZED_ACCESS = "Unauthorized Access!!";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// Get request headers
		final MultivaluedMap<String, String> headers = requestContext.getHeaders();

		// Fetch authorization header
		final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

		// If no authorization information present; block access
		if (authorization == null || authorization.isEmpty()) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(UNATHORIZED_ACCESS).build());
			return;
		}

		// Get encoded username and password
		final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

		// Decode username and password
		String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));

		// Split username and password tokens
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		MUser user = new Query(Env.getCtx(), MUser.Table_Name,
				MUser.COLUMNNAME_Name + "=? AND " + MUser.COLUMNNAME_Password + " =?", null)
						.setParameters(username, password).first();
		if (user == null) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(UNATHORIZED_ACCESS).build());
			return;
		}

		CompiereService service = getCompiereService();
		service.connect();
		service.setPassword(password);
		Env.setContext(service.getCtx(), Env.AD_CLIENT_ID, user.getAD_Client_ID());
		Env.setContext(service.getCtx(), Env.AD_USER_ID, user.get_ID());
		Env.setContext(service.getCtx(), Env.AD_ROLE_ID, 0);

		boolean login = service.login(user.get_ID(), 0, user.getAD_Client_ID(), user.getAD_Org_ID(), 0, "en_US");
		service.disconnect();
		if (!login) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(UNATHORIZED_ACCESS).build());
			return;
		}
	}

	/**
	 * 
	 * @return Compiere Service object for current request
	 */
	private CompiereService getCompiereService() {
		HttpServletRequest req = getHttpServletRequest();

		CompiereService m_cs = (CompiereService) req.getAttribute(COMPIERE_SERVICE);
		if (m_cs == null) {
			m_cs = new CompiereService();
			req.setAttribute(COMPIERE_SERVICE, m_cs);
		}
		return m_cs;
	}

	/**
	 * Get HttpServletRequest object
	 * 
	 * @return HttpServletRequest
	 */
	private HttpServletRequest getHttpServletRequest() {
		HttpServletRequest req = null;
		if (context != null) {
			req = (HttpServletRequest) context.getHttpServletRequest();
		}

		return req;
	}
}
