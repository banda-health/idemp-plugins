package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.AuthResponse;
import org.bandahealth.idempiere.rest.model.Authentication;
import org.bandahealth.idempiere.rest.utils.LoginClaims;
import org.bandahealth.idempiere.rest.utils.TokenUtils;
import org.compiere.model.MUser;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Login;

import java.sql.Timestamp;

/**
 * Authentication Service Accepts Username, password, ad_client_id and generates
 * a session token.
 * 
 * Disclaimer: A lot of the authentication code has been borrowed from
 * https://github.com/hengsin/idempiere-rest.
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.AUTHENTICATION_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationRestService {

	@POST
	@Path(IRestConfigs.AUTHENTICATION_SESSION_PATH)
	public AuthResponse generateSession(Authentication credentials) {
		Login login = new Login(Env.getCtx());
		KeyNamePair[] clients = login.getClients(credentials.getUsername(), credentials.getPassword());
		if (clients == null || clients.length == 0) {
			return new AuthResponse(null, Status.UNAUTHORIZED);
		} else {
			Builder builder = JWT.create().withSubject(credentials.getUsername());
			if (credentials.getClientId() >= 0) {
				builder.withClaim(LoginClaims.AD_Client_ID.name(), credentials.getClientId());
			}
			if (credentials.getRoleId() > 0) {
				builder.withClaim(LoginClaims.AD_Role_ID.name(), credentials.getRoleId());
			}
			if (credentials.getOrganizationId() >= 0) {
				builder.withClaim(LoginClaims.AD_Org_ID.name(), credentials.getOrganizationId());
			}
			if (credentials.getOrganizationId() > 0 && credentials.getWarehouseId() > 0) {
				builder.withClaim(LoginClaims.M_Warehouse_ID.name(), credentials.getOrganizationId());
			}

			Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, credentials.getClientId());
			MUser user = MUser.get(Env.getCtx(), credentials.getUsername());
			builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());

			Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
			builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);
			try {
				String token = builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret()));
				return new AuthResponse(token, Status.OK, Env.getAD_Client_ID(Env.getCtx()), user.get_ID());
			} catch (Exception e) {
				return new AuthResponse(null, Status.BAD_REQUEST);
			}
		}
	}
}