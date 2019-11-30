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
import org.bandahealth.idempiere.rest.model.Client;
import org.bandahealth.idempiere.rest.model.Org;
import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.service.db.TermsOfServiceService;
import org.bandahealth.idempiere.rest.utils.LoginClaims;
import org.bandahealth.idempiere.rest.utils.TokenUtils;
import org.compiere.model.MClient;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MUser;
import org.compiere.model.MWarehouse;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Login;

import java.sql.Timestamp;

/**
 * Authentication Service Accepts Username, password and generates a session
 * token. It attempts to set default client, role, warehouse, org values for
 * clients, else return a list where multiple values are found
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.AUTHENTICATION_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationRestService {

	public AuthenticationRestService() {
	}

	@POST
	@Path(IRestConfigs.AUTHENTICATION_SESSION_PATH)
	public AuthResponse generateSession(Authentication credentials) {
		Login login = new Login(Env.getCtx());
		// retrieve list of clients the user has access to.
		KeyNamePair[] clients = login.getClients(credentials.getUsername(), credentials.getPassword());
		if (clients == null || clients.length == 0) {
			return new AuthResponse(Status.UNAUTHORIZED);
		} else {
			MUser user = MUser.get(Env.getCtx(), credentials.getUsername());
			if (user == null) {
				return new AuthResponse(Status.UNAUTHORIZED);
			}

			if (user.isLocked()) {
				return new AuthResponse(Status.FORBIDDEN);
			}

			if (user.isExpired()) {
				return new AuthResponse(Status.UNAUTHORIZED);
			}

			Builder builder = JWT.create().withSubject(credentials.getUsername());
			Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
			// expires after 60 minutes
			builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);

			AuthResponse response = new AuthResponse();
			// parse all clients that the user has access to.
			for (KeyNamePair client : clients) {
				Client clientResponse = new Client(client.getKey(), client.getName());

				// set default client
				if (clients.length == 1) {
					Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, clientResponse.getId());
					builder.withClaim(LoginClaims.AD_Client_ID.name(), clientResponse.getId());
				}

				// check orgs.
				MOrg[] orgs = MOrg.getOfClient(new MClient(Env.getCtx(), clientResponse.getId(), null));
				for (MOrg org : orgs) {
					Org orgResponse = new Org(org.get_ID(), org.getName());

					// set default org
					if (orgs.length == 1) {
						Env.setContext(Env.getCtx(), Env.AD_ORG_ID, orgResponse.getId());
						builder.withClaim(LoginClaims.AD_Org_ID.name(), orgResponse.getId());
					}

					// check roles
					MRole[] roles = user.getRoles(orgResponse.getId());
					for (MRole role : roles) {
						Role roleResponse = new Role(role.get_ID(), role.getName());
						orgResponse.getRoles().add(roleResponse);

						if (roles.length == 1) {
							Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, roleResponse.getId());
							builder.withClaim(LoginClaims.AD_Role_ID.name(), roleResponse.getId());
						}
					}

					// check warehouses
					MWarehouse[] warehouses = MWarehouse.getForOrg(Env.getCtx(), orgResponse.getId());
					for (MWarehouse warehouse : warehouses) {
						Warehouse warehouseResponse = new Warehouse(warehouse.get_ID(), warehouse.getName());
						orgResponse.getWarehouses().add(warehouseResponse);

						// set default warehouse
						if (warehouses.length == 1) {
							Env.setContext(Env.getCtx(), Env.M_WAREHOUSE_ID, warehouseResponse.getId());
							builder.withClaim(LoginClaims.M_Warehouse_ID.name(), warehouseResponse.getId());
						}
					}

					clientResponse.getOrgs().add(orgResponse);
				}

				response.getClients().add(clientResponse);
			}

			builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());
			Env.setContext(Env.getCtx(), Env.AD_USER_ID, user.getAD_User_ID());
			response.setUserId(user.getAD_User_ID());

			try {
				// generate session token
				response.setToken(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret())));
				// has accepted terms of use?
				response.setHasAcceptedTermsOfUse(TermsOfServiceService.isAccepted());
				// set username
				response.setUsername(credentials.getUsername());
				// status OK.
				response.setStatus(Status.OK);
				return response;
			} catch (Exception e) {
				return new AuthResponse(Status.BAD_REQUEST);
			}
		}
	}
}