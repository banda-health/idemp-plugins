package org.bandahealth.idempiere.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.config.Transaction;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.model.AuthResponse;
import org.bandahealth.idempiere.rest.model.Authentication;
import org.bandahealth.idempiere.rest.model.Client;
import org.bandahealth.idempiere.rest.model.Org;
import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.service.db.RoleDBService;
import org.bandahealth.idempiere.rest.service.db.TermsOfServiceDBService;
import org.bandahealth.idempiere.rest.service.db.WarehouseDBService;
import org.bandahealth.idempiere.rest.utils.LoginClaims;
import org.bandahealth.idempiere.rest.utils.RoleUtil;
import org.bandahealth.idempiere.rest.utils.TokenUtils;
import org.compiere.model.MClient;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MRoleOrgAccess;
import org.compiere.model.MSysConfig;
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Login;
import org.compiere.util.Msg;
import org.compiere.util.Trx;
import org.compiere.util.Util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Authentication Service Accepts Username, password and generates a session
 * token. It attempts to set default client, role, warehouse, org values for
 * clients, else return a list where multiple values are found
 *
 * @author andrew
 */
@Path(IRestConfigs.AUTHENTICATION_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationRestService {

	public static final String M_WAREHOUSE_UUID = "#M_Warehouse_Uuid";
	public static String ERROR_USER_NOT_FOUND = "Could not find user";
	private final WarehouseDBService warehouseDBService = new WarehouseDBService();
	private final RoleDBService roleDBService;

	public AuthenticationRestService() {
		roleDBService = new RoleDBService();
	}

	@POST
	@Path(IRestConfigs.TERMSOFSERVICE_PATH)
	public boolean acceptTermsOfService(@QueryParam("accept") boolean accept) {
		return TermsOfServiceDBService.acceptTermsOfUse(accept);
	}

	@POST
	@Path(IRestConfigs.CHANGEPASSWORD_PATH)
	public AuthResponse changePassword(Authentication credentials) {
		Login login = new Login(Env.getCtx());

		if (Util.isEmpty(credentials.getUsername())) {
			throw new IllegalArgumentException(Msg.getMsg(Env.getCtx(), MMessage_BH.USERNAME_REQUIRED));
		}
		if (Util.isEmpty(credentials.getPassword())) {
			throw new IllegalArgumentException(
					org.compiere.util.Msg.getMsg(Env.getCtx(), MMessage_BH.OLD_PASSWORD_MANDATORY));
		}

		// retrieve list of clients the user has access to.
		KeyNamePair[] clients = login.getClients(credentials.getUsername(), credentials.getPassword());
		// If we're here and they don't have access to clients, it means the
		// username/password combo incorrect
		if (clients == null || clients.length == 0) {
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), MMessage_BH.WRONG_CREDENTIALS));
		}

		MUser user = MUser.get(Env.getCtx(), credentials.getUsername());
		if (user == null) {
			user = checkValidSystemUserWithNoSystemRole(clients, credentials);
		}

		/**
		 * Copied from ChangePasswordPanel > validateChangePassword
		 */
		if (Util.isEmpty(credentials.getNewPassword())) {
			throw new IllegalArgumentException(Msg.getMsg(Env.getCtx(), MMessage_BH.NEW_PASSWORD_MANDATORY));
		}

		if (org.compiere.model.MSysConfig.getBooleanValue(MSysConfig.CHANGE_PASSWORD_MUST_DIFFER, true)) {
			if (credentials.getPassword().equals(credentials.getNewPassword())) {
				throw new IllegalArgumentException(Msg.getMsg(Env.getCtx(), MMessage_BH.NEW_PASSWORD_MUST_DIFFER));
			}
		}

		updateUsersPassword(credentials, clients);
		return this.generateSession(credentials);
	}

	/**
	 * JWT tokens are immutable. We have to generate a new token
	 *
	 * @param credentials
	 * @return
	 */
	@POST
	@Path(IRestConfigs.CHANGEACCESS_PATH)
	public AuthResponse changeAccess(Authentication credentials) {
		try {
			MUser user = MUser.get(Env.getCtx(), credentials.getUsername());
			if (user == null) {
				return new AuthResponse(Status.UNAUTHORIZED);
			}

			// check access permissions
			// client, role & org
			String whereClause = MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_User_ID + " =? AND "
					+ MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Role_UU + " =? AND " + MUser.Table_Name
					+ "." + MUser.COLUMNNAME_IsActive + "=? AND " + MClient.Table_Name + "."
					+ MClient.COLUMNNAME_IsActive + " =? AND " + MClient.Table_Name + "."
					+ MClient.COLUMNNAME_AD_Client_ID + " =? AND " + MRoleOrgAccess.Table_Name + "."
					+ MRoleOrgAccess.COLUMNNAME_AD_Org_ID + " IS NOT NULL";

			List<Object> parameters = new ArrayList<>();
			parameters.add(user.get_ID());
			parameters.add(credentials.getRoleUuid());
			parameters.add("Y");
			parameters.add("Y");
			parameters.add(credentials.getClientId());

			String joinClause = "INNER JOIN " + MUser.Table_Name + " ON " + MUserRoles.Table_Name + "."
					+ MUserRoles.COLUMNNAME_AD_User_ID + "=" + MUser.Table_Name + "." + MUser.COLUMNNAME_AD_User_ID;
			joinClause += " INNER JOIN " + MRole.Table_Name + " ON " + MUserRoles.Table_Name + "." 
					+ MUserRoles.COLUMNNAME_AD_Role_ID + " = " + MRole.Table_Name + "."
					+ MRole.COLUMNNAME_AD_Role_ID;
			joinClause += " INNER JOIN " + MClient.Table_Name + " ON " + MUserRoles.Table_Name + "."
					+ MUserRoles.COLUMNNAME_AD_Client_ID + " = " + MClient.Table_Name + "."
					+ MClient.COLUMNNAME_AD_Client_ID;
			joinClause += " INNER JOIN " + MRoleOrgAccess.Table_Name + " ON " + MRoleOrgAccess.Table_Name + "."
					+ MRoleOrgAccess.COLUMNNAME_AD_Role_ID + " = " + MUserRoles.Table_Name + "."
					+ MUserRoles.COLUMNNAME_AD_Role_ID;

			MUserRoles userRoles = new Query(Env.getCtx(), MUserRoles.Table_Name, whereClause, null)
					.addJoinClause(joinClause).setParameters(parameters).first();
			if (userRoles == null) {
				return new AuthResponse(Status.UNAUTHORIZED);
			}

			// check warehouse access
			List<MBHRoleWarehouseAccess> warehouseAccessList = new Query(Env.getCtx(),
					MBHRoleWarehouseAccess.Table_Name, null, null).list();
			if (!warehouseAccessList.isEmpty()) {
				// get available warehouses
				List<MWarehouse> warehouses = Arrays
						.asList(MWarehouse.getForOrg(Env.getCtx(), credentials.getOrganizationId()));

				Role role = roleDBService.getEntity(credentials.getRoleUuid());
				Optional<MBHRoleWarehouseAccess> foundWarehouseAccess = warehouseAccessList.stream()
						.filter((warehouseAccess) -> {

							Optional<MWarehouse> foundWarehouse = warehouses.stream().filter((warehouse) ->
									warehouse.getM_Warehouse_UU().equalsIgnoreCase(credentials.getWarehouseUuid())
							).findFirst();

							return foundWarehouse.filter(mWarehouse -> warehouseAccess.getRoleId() == role.getId()
									&& mWarehouse.getM_Warehouse_UU().equalsIgnoreCase(credentials.getWarehouseUuid())).isPresent();
						}).findAny();
				if (foundWarehouseAccess.isEmpty()) {
					return new AuthResponse(Status.UNAUTHORIZED);
				}
			}

			Builder builder = JWT.create().withSubject(credentials.getUsername());
			Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
			// expires after 60 minutes
			builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);

			AuthResponse response = new AuthResponse();

			changeLoginProperties(credentials, builder, response);

			builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());
			builder.withClaim(LoginClaims.AD_Language.name(), credentials.getLanguage());
			Env.setContext(Env.getCtx(), Env.AD_USER_ID, user.getAD_User_ID());
			response.setUserId(user.getAD_User_ID());

			try {
				// generate session token
				response.setToken(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret())));
				// has accepted terms of use?
				response.setHasAcceptedTermsOfUse(TermsOfServiceDBService.hasAccepted());
				// set username
				response.setUsername(credentials.getUsername());
				// status OK.
				response.setStatus(Status.OK);
				// isAdministrator
				response.setIsAdministrator(user.isAdministrator());
				// record read-write and deactivate privileges on each window for this role
				response.setWindowAccessLevel(RoleUtil.accessLevelsForRole());
				response.setIncludedRoleUuids(RoleUtil.fetchIncludedRoleUuids());
				return response;
			} catch (Exception e) {
				return new AuthResponse(Status.BAD_REQUEST);
			}

		} catch (IllegalArgumentException e) {
			return new AuthResponse(Status.BAD_REQUEST);
		}
	}

	/**
	 * Handle everything related to updating a user's password. Largely copied from
	 * ChangePasswordPanel > validateChangePassword
	 *
	 * @param credentials
	 * @param clients
	 */
	private void updateUsersPassword(Authentication credentials, KeyNamePair[] clients) {
		Trx trx = null;
		try {
			String trxName = Trx.createTrxName(Transaction.ChangePassword.NAME);
			trx = Trx.get(trxName, true);
			trx.setDisplayName(getClass().getName() + Transaction.ChangePassword.SUFFIX_DISPLAY);

			for (KeyNamePair client : clients) {
				int clientId = client.getKey();
				Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, clientId);
				MUser clientUser = MUser.get(Env.getCtx(), credentials.getUsername());
				if (clientUser == null) {
					trx.rollback();
					throw new AdempiereException(ERROR_USER_NOT_FOUND);
				}

				clientUser.set_ValueOfColumn(MUser.COLUMNNAME_Password, credentials.getNewPassword()); // will be hashed
				// and validate
				// on saveEx
				clientUser.setIsExpired(false);
				// TODO: Add this back in if we start using these
				// clientUser.setSecurityQuestion(credentials.getSecurityQuestion());
				// clientUser.setAnswer(credentials.getAnswer());
				clientUser.saveEx(trx.getTrxName());
			}

			trx.commit();
		} catch (AdempiereException e) {
			if (trx != null)
				trx.rollback();
			throw e;
		} finally {
			if (trx != null)
				trx.close();
		}
		// The user's password has been updated, so update the credentials object, too
		credentials.setPassword(credentials.getNewPassword());
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
				user = checkValidSystemUserWithNoSystemRole(clients, credentials);
			}

			if (user == null) {
				return new AuthResponse(Status.UNAUTHORIZED);
			}

			if (user.isLocked()) {
				return new AuthResponse(Status.FORBIDDEN);
			}

			if (user.isExpired()) {
				return handleUserNeedsToChangePassword(credentials);
			}

			Builder builder = JWT.create().withSubject(credentials.getUsername());
			Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
			// expires after 60 minutes
			builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);

			AuthResponse response = new AuthResponse();

			// has user changed client and role?
			if (credentials.getClientId() != null && credentials.getRoleUuid() != null) {
				changeLoginProperties(credentials, builder, response);
			} else {
				// set default properties
				setDefaultLoginProperties(clients, user, builder, response);
			}

			builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());
			builder.withClaim(LoginClaims.AD_Language.name(), credentials.getLanguage());
			Env.setContext(Env.getCtx(), Env.AD_USER_ID, user.getAD_User_ID());
			response.setUserId(user.getAD_User_ID());

			try {
				// generate session token
				response.setToken(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret())));
				// has accepted terms of use?
				response.setHasAcceptedTermsOfUse(TermsOfServiceDBService.hasAccepted());
				// set username
				response.setUsername(credentials.getUsername());
				// status OK.
				response.setStatus(Status.OK);
				// isAdministrator
				response.setIsAdministrator(user.isAdministrator());
				// record read-write and deactivate privileges on each window for this role
				response.setWindowAccessLevel(RoleUtil.accessLevelsForRole());
				response.setIncludedRoleUuids(RoleUtil.fetchIncludedRoleUuids());
				return response;
			} catch (Exception e) {
				return new AuthResponse(Status.BAD_REQUEST);
			}
		}
	}

	/**
	 * The user needs to change their credentials, so set the appropriate data
	 *
	 * @param credentials
	 * @return
	 */
	private AuthResponse handleUserNeedsToChangePassword(Authentication credentials) {
		List<String> securityQuestions = new ArrayList<>();

		for (int i = 1; i <= MMessage_BH.NO_OF_SECURITY_QUESTION; i++) {
			securityQuestions.add(Msg.getMsg(Env.getCtx(), MMessage_BH.SECURITY_QUESTION_PREFIX + i));
		}
		AuthResponse response = new AuthResponse();
		response.setUsername(credentials.getUsername());
		response.setNeedsToResetPassword(true);
		response.setSecurityQuestions(securityQuestions);
		response.setStatus(Status.OK);
		return response;
	}

	/**
	 * This function will be called when a user has changed login credentials i.e
	 * client, role, warehouse, organization
	 *
	 * @param credentials
	 * @param builder
	 */
	private void changeLoginProperties(Authentication credentials, Builder builder, AuthResponse response) {
		// set client id
		if (credentials.getClientId() != null) {
			MClient client = MClient.get(Env.getCtx(), credentials.getClientId());
			if (client != null) {
				response.getClients().add(new Client(credentials.getClientId(), client.getName()));

				Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, credentials.getClientId());
				builder.withClaim(LoginClaims.AD_Client_ID.name(), credentials.getClientId());
				response.setClientId(credentials.getClientId());
			}
		}

		// set role
		if (credentials.getRoleUuid() != null) {
			Role role = roleDBService.getEntity(credentials.getRoleUuid());
			Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, role.getId());
			builder.withClaim(LoginClaims.AD_Role_ID.name(), role.getId());
			response.setRoleUuid(credentials.getRoleUuid());
		}

		// check organization
		if (credentials.getOrganizationId() != null) {
			Env.setContext(Env.getCtx(), Env.AD_ORG_ID, credentials.getOrganizationId());
			builder.withClaim(LoginClaims.AD_Org_ID.name(), credentials.getOrganizationId());
			response.setOrgId(credentials.getOrganizationId());
		}

		// check warehouse
		if (credentials.getWarehouseUuid() != null) {
			MWarehouse_BH warehouse = warehouseDBService.getByUuids(Collections.singleton(credentials.getWarehouseUuid()))
					.get(credentials.getWarehouseUuid());
			Env.setContext(Env.getCtx(), Env.M_WAREHOUSE_ID, warehouse.get_ID());
			builder.withClaim(LoginClaims.M_Warehouse_ID.name(), warehouse.get_ID());
			response.setWarehouseUuid(credentials.getWarehouseUuid());
		}

	}

	/**
	 * Set default properties
	 *
	 * @param clients
	 * @param user
	 * @param builder
	 * @param response
	 */
	private void setDefaultLoginProperties(KeyNamePair[] clients, MUser user, Builder builder, AuthResponse response) {
		// For querying roles, we'll need to change the client IDs that are used from
		// the context, so store what's there
		// now
		int clientId = Env.getAD_Client_ID(Env.getCtx());
		// PO.setCrossTenantSafe(); // <- uncomment for iDempiere-8.2+
		try {
			// parse all clients that the user has access to.
			for (KeyNamePair client : clients) {
				Client clientResponse = new Client(client.getKey(), client.getName());

				// set default client
				if (clients.length == 1) {
					Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, clientResponse.getId());
					builder.withClaim(LoginClaims.AD_Client_ID.name(), clientResponse.getId());
					response.setClientId(clientResponse.getId());
				}

				// check orgs.
				MOrg[] orgs = MOrg.getOfClient(new MClient(Env.getCtx(), clientResponse.getId(), null));
				for (MOrg org : orgs) {
					Org orgResponse = new Org(org.get_ID(), org.getName());

					// set default org
					if (orgs.length == 1) {
						Env.setContext(Env.getCtx(), Env.AD_ORG_ID, orgResponse.getId());
						builder.withClaim(LoginClaims.AD_Org_ID.name(), orgResponse.getId());
						response.setOrgId(orgResponse.getId());
					}

					// check roles
					Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, clientResponse.getId());
					MRole[] roles = user.getRoles(orgResponse.getId());
					for (MRole role : roles) {
						Role roleResponse = new Role(role);
						orgResponse.getRoles().add(roleResponse);

						if (roles.length == 1) {
							Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, roleResponse.getId());
							builder.withClaim(LoginClaims.AD_Role_ID.name(), roleResponse.getId());
							response.setRoleUuid(roleResponse.getUuid());
						}
					}

					// check warehouses
					MWarehouse[] warehouses = MWarehouse.getForOrg(Env.getCtx(), orgResponse.getId());
					for (MWarehouse warehouse : warehouses) {
						Warehouse warehouseResponse = new Warehouse(warehouse);
						orgResponse.getWarehouses().add(warehouseResponse);

						// set default warehouse
						if (warehouses.length == 1) {
							Env.setContext(Env.getCtx(), Env.M_WAREHOUSE_ID, warehouseResponse.getId());
							builder.withClaim(LoginClaims.M_Warehouse_ID.name(), warehouseResponse.getId());
							response.setWarehouseUuid(warehouseResponse.getUuid());
						}
					}

					clientResponse.getOrgs().add(orgResponse);
				}

				response.getClients().add(clientResponse);
			}
		} finally {
			Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, clientId);
			// PO.clearCrossTenantSafe(); // <- uncomment for iDempiere-8.2+
		}
	}

	/**
	 * Check valid system users with no system role.
	 *
	 * @param clients
	 * @param credentials
	 * @return
	 */
	private MUser checkValidSystemUserWithNoSystemRole(KeyNamePair[] clients, Authentication credentials) {
		MUser user = null;
		for (KeyNamePair client : clients) {
			// update context with client id

			Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, client.getKey());
			user = MUser.get(Env.getCtx(), credentials.getUsername());
			if (user != null) {
				break;
			}
		}

		return user;
	}

}