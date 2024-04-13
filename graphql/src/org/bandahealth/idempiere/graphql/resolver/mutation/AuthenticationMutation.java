package org.bandahealth.idempiere.graphql.resolver.mutation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.config.Transaction;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.AuthenticationResponse;
import org.bandahealth.idempiere.graphql.model.ChangeAccessResponse;
import org.bandahealth.idempiere.graphql.model.input.AuthenticationInput;
import org.bandahealth.idempiere.graphql.model.input.ChangeAccessInput;
import org.bandahealth.idempiere.graphql.model.input.ChangePasswordInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.LoginClaims;
import org.bandahealth.idempiere.graphql.utils.TokenUtils;
import org.compiere.model.MClient;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MSession;
import org.compiere.model.MSysConfig;
import org.compiere.model.MUser;
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
import java.util.List;
import java.util.Properties;

/**
 * Handle all mutations relating to authentication
 */
public class AuthenticationMutation implements GraphQLMutationResolver {

	/**
	 * The sign-in method to authentication a user
	 *
	 * @param credentials The login information passed in by a user.
	 * @param environment The environment associated with all calls, containing context.
	 * @return An appropriate response containing a JWT token and user information.
	 */
	public AuthenticationResponse SignIn(AuthenticationInput credentials, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		Login login = new Login(idempiereContext);
		// retrieve list of clients the user has access to.
		KeyNamePair[] clients = login.getClients(credentials.getUsername(), credentials.getPassword());
		if (clients == null || clients.length == 0) {
			throw new AdempiereException("Unauthorized");
		}
		MUser user = MUser.get(idempiereContext, credentials.getUsername(), credentials.getPassword());
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

		JWTCreator.Builder builder = JWT.create().withSubject(credentials.getUsername());
		Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
		builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);

		AuthenticationResponse response = new AuthenticationResponse();
		builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());
		builder.withClaim(LoginClaims.AD_Language.name(), credentials.getAD_Language());
		Env.setContext(idempiereContext, Env.AD_USER_ID, user.getAD_User_ID());
		response.setAD_User(new MUser_BH(idempiereContext, user.getAD_User_ID(), null));

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
	 * @param changePasswordInput The login and change-password information passed in by a user.
	 * @param environment         The environment associated with all calls, containing context.
	 * @return An appropriate response containing a JWT token and user information.
	 */
	public Boolean ChangePassword(ChangePasswordInput changePasswordInput, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		Login login = new Login(idempiereContext);

		if (Util.isEmpty(changePasswordInput.getUsername())) {
			throw new IllegalArgumentException(Msg.getMsg(idempiereContext, MMessage_BH.USERNAME_REQUIRED));
		}
		if (Util.isEmpty(changePasswordInput.getPassword())) {
			throw new IllegalArgumentException(Msg.getMsg(idempiereContext, MMessage_BH.OLD_PASSWORD_MANDATORY));
		}

		// retrieve list of clients the user has access to.
		KeyNamePair[] clients = login.getClients(changePasswordInput.getUsername(), changePasswordInput.getPassword());
		// If we're here and they don't have access to clients, it means the
		// username/password combo incorrect
		if (clients == null || clients.length == 0) {
			throw new AdempiereException(Msg.getMsg(idempiereContext, MMessage_BH.WRONG_CREDENTIALS));
		}

		// Copied from ChangePasswordPanel > validateChangePassword
		if (Util.isEmpty(changePasswordInput.getNewPassword())) {
			throw new IllegalArgumentException(Msg.getMsg(idempiereContext, MMessage_BH.NEW_PASSWORD_MANDATORY));
		}

		if (MSysConfig.getBooleanValue(MSysConfig.CHANGE_PASSWORD_MUST_DIFFER, true)) {
			if (changePasswordInput.getPassword().equals(changePasswordInput.getNewPassword())) {
				throw new IllegalArgumentException(Msg.getMsg(idempiereContext, MMessage_BH.NEW_PASSWORD_MUST_DIFFER));
			}
		}
		MUser user = MUser.get(idempiereContext, changePasswordInput.getUsername(), changePasswordInput.getPassword());
		if (user == null) {
			throw new AdempiereException("Unauthorized");
		}

		updateUsersPassword(changePasswordInput, clients, idempiereContext);
		return true;
	}

	/**
	 * JWT tokens are immutable. We have to generate a new token
	 */
	public ChangeAccessResponse ChangeAccess(ChangeAccessInput changeAccessInput, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		try {
			MUser user = MUser.get(idempiereContext, Env.getAD_User_ID(idempiereContext));
			if (user == null) {
				throw new AdempiereException("Unauthorized");
			}
			MOrg organization = new MOrg(idempiereContext, changeAccessInput.getAD_Org_UU(), null);
			if (organization.get_ID() == 0) {
				throw new AdempiereException("Unauthorized");
			}
			MClient client = MClient.get(organization.getAD_Client_ID());
			if (!client.getAD_Client_UU().equals(changeAccessInput.getAD_Client_UU())) {
				throw new AdempiereException("Unauthorized");
			}
			Env.setContext(idempiereContext, Env.AD_CLIENT_ID, client.getAD_Client_ID());
			Repository.setCopyOfPropertiesForNestedThreadUsage(idempiereContext);

			// check access permissions
			List<MRole> roles = Arrays.asList(user.getRoles(organization.get_ID()));
			MRole role;
			if (roles.isEmpty() || (role = roles.stream()
					.filter(availableRole -> availableRole.getAD_Role_UU().equals(changeAccessInput.getAD_Role_UU())).findFirst()
					.orElse(null)) == null) {
				throw new AdempiereException("Unauthorized");
			}

			// check warehouse access
			List<MBHRoleWarehouseAccess> warehouseAccessList =
					new Query(idempiereContext, MBHRoleWarehouseAccess.Table_Name, null, null).list();
			MWarehouse warehouse = Arrays.stream(MWarehouse.getForOrg(idempiereContext, organization.get_ID())).filter(
							organizationWarehouse -> organizationWarehouse.getM_Warehouse_UU()
									.equals(changeAccessInput.getM_Warehouse_UU()))
					.findFirst().orElse(null);
			// If we didn't find a warehouse, or the user doesn't have access to it, unauthorized
			if (warehouse == null || (!warehouseAccessList.isEmpty() && warehouseAccessList.stream().noneMatch(
					warehouseAccess -> warehouseAccess.getAD_Role_ID() == role.getAD_Role_ID() &&
							warehouse.get_ID() == warehouseAccess.getM_Warehouse_ID()))) {
				throw new AdempiereException("Unauthorized");
			}
			PO.clearCrossTenantSafe();

			JWTCreator.Builder builder = JWT.create().withSubject(user.getName());
			Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
			// expires after 60 minutes
			builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);

			AuthenticationResponse response = new AuthenticationResponse();

			// set client id
			Env.setContext(idempiereContext, Env.AD_CLIENT_ID, client.getAD_Client_ID());
			builder.withClaim(LoginClaims.AD_Client_ID.name(), client.getAD_Client_ID());

			// set role
			Env.setContext(idempiereContext, Env.AD_ROLE_ID, role.getAD_Role_ID());
			builder.withClaim(LoginClaims.AD_Role_ID.name(), role.getAD_Role_ID());

			// set organization
			Env.setContext(idempiereContext, Env.AD_ORG_ID, organization.getAD_Org_ID());
			builder.withClaim(LoginClaims.AD_Org_ID.name(), organization.getAD_Org_ID());

			// set warehouse
			Env.setContext(idempiereContext, Env.M_WAREHOUSE_ID, warehouse.get_ID());
			builder.withClaim(LoginClaims.M_Warehouse_ID.name(), warehouse.get_ID());

			// set session
			MSession session = MSession.get(idempiereContext);
			if (session == null) {
				session = MSession.create(idempiereContext);
				session.setWebSession("idempiere-graphql");
				session.saveEx();
			}
			builder.withClaim(LoginClaims.AD_Session_ID.name(), session.getAD_Session_ID());

			// suer user and language
			builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());
			builder.withClaim(LoginClaims.AD_Language.name(), Env.getAD_Language(idempiereContext));
			Env.setContext(idempiereContext, Env.AD_USER_ID, user.getAD_User_ID());

			try {
				// generate session token
				response.setToken(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret())));
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
	 * @param changePasswordInput
	 * @param clients
	 */
	private void updateUsersPassword(ChangePasswordInput changePasswordInput, KeyNamePair[] clients,
			Properties idempiereContext) {
		Trx trx = null;
		try {
			String trxName = Trx.createTrxName(Transaction.ChangePassword.NAME);
			trx = Trx.get(trxName, true);
			trx.setDisplayName(getClass().getName() + Transaction.ChangePassword.SUFFIX_DISPLAY);

			for (KeyNamePair client : clients) {
				int clientId = client.getKey();
				Env.setContext(idempiereContext, Env.AD_CLIENT_ID, clientId);
				MUser clientUser =
						MUser.get(idempiereContext, changePasswordInput.getUsername(), changePasswordInput.getPassword());
				if (clientUser == null) {
					trx.rollback();
					throw new AdempiereException("Could not find user");
				}

				clientUser.setPassword(changePasswordInput.getNewPassword()); // will be hashed
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
		changePasswordInput.setPassword(changePasswordInput.getNewPassword());
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
}
