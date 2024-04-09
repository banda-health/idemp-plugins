package org.bandahealth.idempiere.graphql.resolver.query;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.config.Transaction;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.AuthenticationResponse;
import org.bandahealth.idempiere.graphql.model.ChangeAccessResponse;
import org.bandahealth.idempiere.graphql.model.input.AuthenticationInput;
import org.bandahealth.idempiere.graphql.model.input.ChangeAccessInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.LoginClaims;
import org.bandahealth.idempiere.graphql.utils.TokenUtils;
import org.compiere.model.MClient;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MRoleOrgAccess;
import org.compiere.model.MSysConfig;
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
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
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Handle all queries relating to authentication
 */
public class AuthenticationQuery implements GraphQLQueryResolver {

	/**
	 * The sign-in method to authentication a user
	 *
	 * @param Credentials The login information passed in by a user.
	 * @param environment The environment associated with all calls, containing context.
	 * @return An appropriate response containing a JWT token and user information.
	 */
	public AuthenticationResponse SignIn(AuthenticationInput Credentials, DataFetchingEnvironment environment) {
//		return authenticationRepository.signIn(credentials, BandaGraphQLContext.getCtx(environment));
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		Login login = new Login(idempiereContext);
		// retrieve list of clients the user has access to.
		KeyNamePair[] clients = login.getClients(Credentials.getUsername(), Credentials.getPassword());
		if (clients == null || clients.length == 0) {
			throw new AdempiereException("Unauthorized");
		}
		MUser user = MUser.get(idempiereContext, Credentials.getUsername(), Credentials.getPassword());
		if (user == null) {
			throw new AdempiereException("Unauthorized");
		}

		if (user.isLocked()) {
			throw new AdempiereException("Forbidden");
		}

		if (user.isExpired()) {
			return handleUserNeedsToChangePassword(new MUser_BH(idempiereContext, user.getAD_User_ID(), null),
					idempiereContext);
		}

		JWTCreator.Builder builder = JWT.create().withSubject(Credentials.getUsername());
		Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
		// expires after 60 minutes
		builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);

		AuthenticationResponse response = new AuthenticationResponse();
		builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());
		builder.withClaim(LoginClaims.AD_Language.name(), Credentials.getAD_Language());
		Env.setContext(idempiereContext, Env.AD_USER_ID, user.getAD_User_ID());
		response.setAD_User(new MUser_BH(idempiereContext, user.getAD_User_ID(), null));

		// has user changed client and role?
		if (Credentials.getAD_Client_UU() != null && Credentials.getAD_Role_UU() != null) {
			changeLoginProperties(Credentials, builder, response, idempiereContext);
		} else {
			// set default properties
			setDefaultLoginProperties(clients, user, builder, response, idempiereContext);
		}

		try {
			// generate session token
			response.setToken(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret())));
			return response;
		} catch (Exception e) {
			throw new AdempiereException("Bad request");
		}
	}

	/**
	 * The method that allows a user to change their password.
	 *
	 * @param Credentials The login and change-password information passed in by a user.
	 * @param environment The environment associated with all calls, containing context.
	 * @return An appropriate response containing a JWT token and user information.
	 */
	public AuthenticationResponse ChangePassword(AuthenticationInput Credentials, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		Login login = new Login(idempiereContext);

		if (Util.isEmpty(Credentials.getUsername())) {
			throw new IllegalArgumentException(Msg.getMsg(idempiereContext, MMessage_BH.USERNAME_REQUIRED));
		}
		if (Util.isEmpty(Credentials.getPassword())) {
			throw new IllegalArgumentException(
					Msg.getMsg(idempiereContext, MMessage_BH.OLD_PASSWORD_MANDATORY));
		}

		// retrieve list of clients the user has access to.
		KeyNamePair[] clients = login.getClients(Credentials.getUsername(), Credentials.getPassword());
		// If we're here and they don't have access to clients, it means the
		// username/password combo incorrect
		if (clients == null || clients.length == 0) {
			throw new AdempiereException(Msg.getMsg(idempiereContext, MMessage_BH.WRONG_CREDENTIALS));
		}

		/**
		 * Copied from ChangePasswordPanel > validateChangePassword
		 */
		if (Util.isEmpty(Credentials.getNewPassword())) {
			throw new IllegalArgumentException(Msg.getMsg(idempiereContext, MMessage_BH.NEW_PASSWORD_MANDATORY));
		}

		if (MSysConfig.getBooleanValue(MSysConfig.CHANGE_PASSWORD_MUST_DIFFER, true)) {
			if (Credentials.getPassword().equals(Credentials.getNewPassword())) {
				throw new IllegalArgumentException(Msg.getMsg(idempiereContext, MMessage_BH.NEW_PASSWORD_MUST_DIFFER));
			}
		}
		MUser user = MUser.get(idempiereContext, Credentials.getUsername(), Credentials.getPassword());
		if (user == null) {
			throw new AdempiereException("Unauthorized");
		}

		updateUsersPassword(Credentials, clients, idempiereContext);
		return this.SignIn(Credentials, environment);
	}

	/**
	 * JWT tokens are immutable. We have to generate a new token
	 *
	 * @param Credentials
	 * @return
	 */
	public ChangeAccessResponse ChangeAccess(ChangeAccessInput Credentials, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		try {
			MUser user = MUser.get(idempiereContext, Env.getAD_User_ID(idempiereContext));
			if (user == null) {
				throw new AdempiereException("Unauthorized");
			}

			// check access permissions
			// client, role & org
			String whereClause = MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_User_ID + " =? AND "
					+ MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Role_UU + " =? AND " + MUser.Table_Name + "."
					+ MUser.COLUMNNAME_IsActive + "=? AND " + MClient.Table_Name + "." + MClient.COLUMNNAME_IsActive
					+ " =? AND " + MClient.Table_Name + "." + MClient.COLUMNNAME_AD_Client_UU + " =? AND "
					+ MRoleOrgAccess.Table_Name + "." + MRoleOrgAccess.COLUMNNAME_AD_Org_ID + " IS NOT NULL";

			List<Object> parameters = new ArrayList<>();
			parameters.add(user.get_ID());
			parameters.add(Credentials.getAD_Role_UU());
			parameters.add("Y");
			parameters.add("Y");
			parameters.add(Credentials.getAD_Client_UU());

			String joinClause = "INNER JOIN " + MUser.Table_Name + " ON " + MUserRoles.Table_Name + "."
					+ MUserRoles.COLUMNNAME_AD_User_ID + "=" + MUser.Table_Name + "." + MUser.COLUMNNAME_AD_User_ID;
			joinClause += " INNER JOIN " + MRole.Table_Name + " ON " + MUserRoles.Table_Name + "."
					+ MUserRoles.COLUMNNAME_AD_Role_ID + " = " + MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Role_ID;
			joinClause += " INNER JOIN " + MClient.Table_Name + " ON " + MUserRoles.Table_Name + "."
					+ MUserRoles.COLUMNNAME_AD_Client_ID + " = " + MClient.Table_Name + "."
					+ MClient.COLUMNNAME_AD_Client_ID;
			joinClause += " INNER JOIN " + MRoleOrgAccess.Table_Name + " ON " + MRoleOrgAccess.Table_Name + "."
					+ MRoleOrgAccess.COLUMNNAME_AD_Role_ID + " = " + MUserRoles.Table_Name + "."
					+ MUserRoles.COLUMNNAME_AD_Role_ID;

			PO.setCrossTenantSafe();
			MUserRoles userRoles = new Query(idempiereContext, MUserRoles.Table_Name, whereClause, null)
					.addJoinClause(joinClause).setParameters(parameters).first();
			if (userRoles == null) {
				throw new AdempiereException("Unauthorized");
			}

			// check warehouse access
			List<MBHRoleWarehouseAccess> warehouseAccessList = new Query(idempiereContext,
					MBHRoleWarehouseAccess.Table_Name, null, null).list();
			if (!warehouseAccessList.isEmpty()) {
				// fetch organization
				MOrg organization = (MOrg) Repository.getByUuids(idempiereContext, MOrg.Table_Name, null,
						Collections.singleton(Credentials.getAD_Org_UU())).get(Credentials.getAD_Org_UU());
				// get available warehouses
				List<MWarehouse> warehouses = Arrays.asList(MWarehouse.getForOrg(idempiereContext, organization.get_ID()));

				MRole role = Repository.getByUuid(idempiereContext, MRole.Table_Name, null, Credentials.getAD_Role_UU());
				Optional<MBHRoleWarehouseAccess> foundWarehouseAccess = warehouseAccessList.stream()
						.filter((warehouseAccess) -> {

							Optional<MWarehouse> foundWarehouse = warehouses.stream().filter((warehouse) -> warehouse
									.getM_Warehouse_UU().equalsIgnoreCase(Credentials.getM_Warehouse_UU())).findFirst();

							return foundWarehouse
									.filter(mWarehouse -> warehouseAccess.getAD_Role_ID() == role.getAD_Role_ID() && mWarehouse
											.getM_Warehouse_UU().equalsIgnoreCase(Credentials.getM_Warehouse_UU()))
									.isPresent();
						}).findAny();
				if (foundWarehouseAccess.isEmpty()) {
					throw new AdempiereException("Unauthorized");
				}
			}
			PO.clearCrossTenantSafe();

			JWTCreator.Builder builder = JWT.create().withSubject(Credentials.getUsername());
			Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
			// expires after 60 minutes
			builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);

			AuthenticationResponse response = new AuthenticationResponse();

			changeLoginProperties(Credentials, builder, response, idempiereContext);

			builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());
			builder.withClaim(LoginClaims.AD_Language.name(), Credentials.getAD_Language());
			Env.setContext(idempiereContext, Env.AD_USER_ID, user.getAD_User_ID());

			try {
				// generate session token
				response.setToken(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret())));
//				// record read-write and deactivate privileges on each window for this role
//				response.setWindowAccessLevel(RoleUtil.accessLevelsForRole());
//				response.setIncludedRoleUuids(RoleUtil.fetchIncludedRoleUuids());
				return response;
			} catch (Exception e) {
				throw new AdempiereException("Bad request");
			}

		} catch (IllegalArgumentException e) {
			throw new AdempiereException("Bad request");
		}
	}

	/**
	 * Handle everything related to updating a user's password. Largely copied from
	 * ChangePasswordPanel > validateChangePassword
	 *
	 * @param credentials
	 * @param clients
	 */
	private void updateUsersPassword(AuthenticationInput credentials, KeyNamePair[] clients,
			Properties idempiereContext) {
		Trx trx = null;
		try {
			String trxName = Trx.createTrxName(Transaction.ChangePassword.NAME);
			trx = Trx.get(trxName, true);
			trx.setDisplayName(getClass().getName() + Transaction.ChangePassword.SUFFIX_DISPLAY);

			for (KeyNamePair client : clients) {
				int clientId = client.getKey();
				Env.setContext(idempiereContext, Env.AD_CLIENT_ID, clientId);
				MUser clientUser = MUser.get(idempiereContext, credentials.getUsername(), credentials.getPassword());
				if (clientUser == null) {
					trx.rollback();
					throw new AdempiereException("Could not find user");
				}

				clientUser.setPassword(credentials.getNewPassword()); // will be hashed
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

	/**
	 * The user needs to change their credentials, so set the appropriate data
	 *
	 * @param user
	 * @return
	 */
	private AuthenticationResponse handleUserNeedsToChangePassword(MUser_BH user, Properties idempiereContext) {
		List<String> securityQuestions = new ArrayList<>();

		for (int i = 1; i <= MMessage_BH.NO_OF_SECURITY_QUESTION; i++) {
			securityQuestions.add(Msg.getMsg(idempiereContext, MMessage_BH.SECURITY_QUESTION_PREFIX + i));
		}
		AuthenticationResponse response = new AuthenticationResponse();
		response.setAD_User(user);
		response.setSecurityQuestions(securityQuestions);
		return response;
	}

	/**
	 * This function will be called when a user has changed login credentials i.e
	 * client, role, warehouse, organization
	 *
	 * @param credentials
	 * @param builder
	 */
	private void changeLoginProperties(ChangeAccessInput credentials, JWTCreator.Builder builder,
			AuthenticationResponse response, Properties idempiereContext) {
		// set client id
		if (credentials.getAD_Client_UU() != null) {
			MClient_BH client = new Query(idempiereContext, MClient.Table_Name, MClient.COLUMNNAME_AD_Client_UU +
					"=?", null).setParameters(credentials.getAD_Client_UU()).first();
			if (client != null) {
				response.getAD_Clients().add(client);

				Env.setContext(idempiereContext, Env.AD_CLIENT_ID, client.getAD_Client_ID());
				builder.withClaim(LoginClaims.AD_Client_ID.name(), client.getAD_Client_ID());
			}
		}

		// set role
		if (credentials.getAD_Role_UU() != null) {
			MRole role = new Query(idempiereContext, MRole.Table_Name, MRole.COLUMNNAME_AD_Role_UU + "=?",
					null).setParameters(credentials.getAD_Role_UU()).first();
			Env.setContext(idempiereContext, Env.AD_ROLE_ID, role.getAD_Role_ID());
			builder.withClaim(LoginClaims.AD_Role_ID.name(), role.getAD_Role_ID());
			response.setAD_Role(role);
		}

		// check organization
		if (credentials.getAD_Org_UU() != null) {
			MOrg organization = new Query(idempiereContext, MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?",
					null).setParameters(credentials.getAD_Org_UU()).first();
			Env.setContext(idempiereContext, Env.AD_ORG_ID, organization.getAD_Org_ID());
			builder.withClaim(LoginClaims.AD_Org_ID.name(), organization.getAD_Org_ID());
		}

		// check warehouse
		if (credentials.getM_Warehouse_UU() != null) {
			MWarehouse warehouse = new Query(idempiereContext, MWarehouse.Table_Name,
					MWarehouse.COLUMNNAME_M_Warehouse_UU + "=?", null)
					.setParameters(credentials.getM_Warehouse_UU()).first();
			Env.setContext(idempiereContext, Env.M_WAREHOUSE_ID, warehouse.get_ID());
			builder.withClaim(LoginClaims.M_Warehouse_ID.name(), warehouse.get_ID());
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
	private void setDefaultLoginProperties(KeyNamePair[] clients, MUser user, JWTCreator.Builder builder,
			AuthenticationResponse response, Properties idempiereContext) {
		// parse all clients that the user has access to.
		PO.setCrossTenantSafe();
		Repository.setApplyAccessFilterNotNeeded();
		Map<Integer, MClient_BH> clientsById = Repository.getByIds(idempiereContext, MClient_BH.Table_Name, null,
				Arrays.stream(clients).map(KeyNamePair::getKey).collect(Collectors.toSet()));

		response.setAD_Clients(new ArrayList<>(clientsById.values()));

		// set default client
		if (clients.length == 1) {
			Env.setContext(idempiereContext, Env.AD_CLIENT_ID, clients[0].getKey());
			builder.withClaim(LoginClaims.AD_Client_ID.name(), clients[0].getKey());

			MOrg[] organizations =
					MOrg.getOfClient(new MClient(idempiereContext, clients[0].getKey(), null));

			// set default org
			if (organizations.length == 1) {
				Env.setContext(idempiereContext, Env.AD_ORG_ID, organizations[0].getAD_Org_ID());
				builder.withClaim(LoginClaims.AD_Org_ID.name(), organizations[0].getAD_Org_ID());

				// check roles
				MRole[] roles = user.getRoles(organizations[0].getAD_Org_ID());
				if (roles.length == 1) {
					MRole role = roles[0];
					Env.setContext(idempiereContext, Env.AD_ROLE_ID, role.getAD_Role_ID());
					builder.withClaim(LoginClaims.AD_Role_ID.name(), role.getAD_Role_ID());
					response.setAD_Role(role);
				}

				MWarehouse[] warehouses = MWarehouse.getForOrg(idempiereContext, organizations[0].getAD_Org_ID());
				// set default warehouse
				if (warehouses.length == 1) {
					Env.setContext(idempiereContext, Env.M_WAREHOUSE_ID, warehouses[0].get_ID());
					builder.withClaim(LoginClaims.M_Warehouse_ID.name(), warehouses[0].get_ID());
				}
			}
		}
		Repository.clearApplyAccessFilterNotNeeded();
		PO.clearCrossTenantSafe();
	}
}