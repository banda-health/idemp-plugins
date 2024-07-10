package org.bandahealth.idempiere.graphql.resolver.mutation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import graphql.kickstart.servlet.context.GraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.config.Transaction;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.AuthenticationCookie;
import org.bandahealth.idempiere.graphql.model.AuthenticationResponse;
import org.bandahealth.idempiere.graphql.model.input.AuthenticationInput;
import org.bandahealth.idempiere.graphql.model.input.ChangeAccessInput;
import org.bandahealth.idempiere.graphql.model.input.ChangePasswordInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.LoginClaims;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
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
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Login;
import org.compiere.util.Msg;
import org.compiere.util.Trx;
import org.compiere.util.Util;

import javax.servlet.http.Cookie;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Handle all mutations relating to authentication
 */
public class AuthenticationMutation implements GraphQLMutationResolver {

	private static final CLogger log = CLogger.getCLogger(AuthenticationMutation.class);

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
		PO.setCrossTenantSafe();
		MUser user = MUser.get(idempiereContext, credentials.getUsername(), credentials.getPassword());
		PO.clearCrossTenantSafe();
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

		JWTCreator.Builder builder = JWT.create();
		handleAccessChange(credentials, user, builder, idempiereContext);
		AuthenticationResponse response = new AuthenticationResponse();
		response.setAD_User(new MUser_BH(idempiereContext, user.getAD_User_ID(), null));

		try {
			// generate session cookie
			((GraphQLServletContext) environment.getContext()).getHttpServletResponse()
					.addCookie(new AuthenticationCookie(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret()))));
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
		PO.setCrossTenantSafe();
		MUser user = MUser.get(idempiereContext, changePasswordInput.getUsername(), changePasswordInput.getPassword());
		PO.clearCrossTenantSafe();
		if (user == null) {
			throw new AdempiereException("Unauthorized");
		}

		updateUsersPassword(changePasswordInput, clients, idempiereContext);
		JWTCreator.Builder builder = JWT.create();
		handleAccessChange(null, user, builder, idempiereContext);
		// generate session cookie
		((GraphQLServletContext) environment.getContext()).getHttpServletResponse()
				.addCookie(new AuthenticationCookie(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret()))));
		return true;
	}

	/**
	 * JWT tokens are immutable. We have to generate a new token
	 */
	public Boolean ChangeAccess(ChangeAccessInput changeAccessInput, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		try {
			PO.setCrossTenantSafe();
			MUser user = MUser.get(idempiereContext, Env.getAD_User_ID(idempiereContext));
			PO.clearCrossTenantSafe();
			if (user == null) {
				throw new AdempiereException("Unauthorized");
			}

			JWTCreator.Builder builder = JWT.create();
			handleAccessChange(changeAccessInput, user, builder, idempiereContext);

			try {
				// generate session cookie
				((GraphQLServletContext) environment.getContext()).getHttpServletResponse()
						.addCookie(new AuthenticationCookie(builder.sign(Algorithm.HMAC256(TokenUtils.getTokenSecret()))));
				return true;
			} catch (Exception e) {
				throw new AdempiereException("Bad request");
			}

		} catch (IllegalArgumentException e) {
			throw new AdempiereException("Bad request");
		}
	}

	/**
	 * Logs the current user out and ends the session
	 *
	 * @param environment The data fetching environment
	 * @return Whether the logout was successful
	 */
	public Boolean Logout(DataFetchingEnvironment environment) {
		try {
			MSession.get(BandaGraphQLContext.getCtx(environment)).logout();
		} catch (Exception e) {
			log.warning("Could not log session out with ID : " +
					MSession.get(BandaGraphQLContext.getCtx(environment)).getAD_Session_ID());
		}
		Cookie authenticationCookieToClear = new AuthenticationCookie("");
		authenticationCookieToClear.setMaxAge(0);
		((GraphQLServletContext) environment.getContext()).getHttpServletResponse().addCookie(authenticationCookieToClear);
		return true;
	}

	/**
	 * Handle setting up the token correctly based on the requested access
	 *
	 * @param changeAccessInput The desired access information
	 * @param user              What user we're working with
	 * @param builder           The JWT builder to set the appropriate information
	 * @param idempiereContext  The context we're using
	 */
	private void handleAccessChange(ChangeAccessInput changeAccessInput, MUser user, JWTCreator.Builder builder,
			Properties idempiereContext) {
		builder.withSubject(user.getName());
		Timestamp expiresAt = TokenUtils.getTokeExpiresAt();
		// expires after 60 minutes
		builder.withIssuer(TokenUtils.getTokenIssuer()).withExpiresAt(expiresAt);

		// set session
		MSession session = MSession.get(idempiereContext);
		if (session != null) {
			session.logout();
		}
		session = MSession.create(idempiereContext);
		session.setWebSession("idempiere-graphql");
		session.saveEx();
		builder.withClaim(LoginClaims.AD_Session_ID.name(), session.getAD_Session_ID());

		// add user and language
		builder.withClaim(LoginClaims.AD_User_ID.name(), user.getAD_User_ID());
		builder.withClaim(LoginClaims.AD_Language.name(), Env.getAD_Language(idempiereContext));
		Env.setContext(idempiereContext, Env.AD_USER_ID, user.getAD_User_ID());

		// If there isn't an organization, we can't do anything, so just return
		if (changeAccessInput == null || StringUtil.isNullOrEmpty(changeAccessInput.getAD_Org_UU())) {
			return;
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
				PO.setCrossTenantSafe();
				MUser clientUser =
						MUser.get(idempiereContext, changePasswordInput.getUsername(), changePasswordInput.getPassword());
				PO.clearCrossTenantSafe();
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

	/**
	 * Check if a particular username and password have access to any clients other than this one.
	 * This is used when creating or updating a username and/or password, to try to ensure someone
	 * doesn't accidentally set up a user at one client that matches one at a DIFFERENT client,
	 * inadvertantly giving them access to both.
	 *
	 * @param credentials
	 * @return true if the username/password has access to other clients, false if they don't
	 */
	public boolean LoginCheckOtherClients(AuthenticationInput credentials, DataFetchingEnvironment environment) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		Login login = new Login(idempiereContext);

		int currentClient = Env.getAD_Client_ID(idempiereContext);

		// Retrieve list of clients that the passed in username and password already has access to.
		KeyNamePair[] clients = login.getClients(credentials.getUsername(), credentials.getPassword());
		if (clients == null) {
			return false;
		}

		for (KeyNamePair client : clients) {
			if (client.getKey() != currentClient) {
				// We found a client that the given username and password has access to, that is NOT the same is THIS client.
				return true;
			}
		}

		return false;
	}
}
