package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MClientQuery extends X_AD_ClientQuery {
	public String getClientLimitingWhereClause(List<Object> parameters, DataFetchingEnvironment environment) {
		Properties iDempiereContext = BandaGraphQLContext.getCtx(environment);
		// Copied from org.compiere.util.Login#getClients
		String sql = """
				SELECT DISTINCT cli.AD_Client_ID
				FROM AD_User_Roles ur
					INNER JOIN AD_Role r on (ur.AD_Role_ID=r.AD_Role_ID)
					INNER JOIN AD_User u on (ur.AD_User_ID=u.AD_User_ID)
					INNER JOIN AD_Client cli on (ur.AD_Client_ID=cli.AD_Client_ID)
				WHERE ur.IsActive='Y'
					AND u.IsActive='Y'
					AND cli.IsActive='Y'
					AND cli.AuthenticationType IN ('APO', 'AAS')
					AND ur.AD_User_ID=?
				ORDER BY cli.AD_Client_ID""";
		Set<Integer> clientIdsForUser = new HashSet<>();
		try (PreparedStatement preparedStatement = DB.prepareStatement(sql, null)) {
			preparedStatement.setInt(1, Env.getAD_User_ID(iDempiereContext));
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					clientIdsForUser.add(resultSet.getInt("AD_Client_ID"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "AD_Client.AD_Client_ID IN (" +
				QueryUtil.getWhereClauseAndSetParametersForSet(clientIdsForUser, parameters) + ")";
	}

	@Override
	public Connection<MClient_BH> AD_ClientGet(int page, int pageSize, String sort, String filter, String Where,
			List<Object> Parameters, DataFetchingEnvironment environment) {
		Properties iDempiereContext = BandaGraphQLContext.getCtx(environment);
		try {
			List<Object> parameters = new ArrayList<>();
			String clientLimitingWhereClause = getClientLimitingWhereClause(parameters, environment);
			if (Env.getAD_Client_ID(iDempiereContext) == 0) {
				Repository.setApplyAccessFilterNotNeeded();
			}
			return Repository.get(getTableName(), null, new PagingInfo(page, pageSize), sort, filter,
					clientLimitingWhereClause, parameters, null, environment);
		} finally {
			if (Env.getAD_Client_ID(iDempiereContext) == 0) {
				Repository.clearApplyAccessFilterNotNeeded();
			}
		}
	}

	@Override
	public CompletableFuture<MClient_BH> AD_Client(String UU, DataFetchingEnvironment environment) {
		return CompletableFuture.supplyAsync(() -> {
			Properties iDempiereContext = BandaGraphQLContext.getCtx(environment);
			// Since we'll already filter by what the user has below, clear any client ID on the context
			Env.setContext(iDempiereContext, Env.AD_CLIENT_ID, 0);
			try {
				List<Object> parameters = new ArrayList<>();
				parameters.add(UU);
				String whereClause = getClientLimitingWhereClause(parameters, environment);
				return new Query(iDempiereContext, MClient_BH.Table_Name,
						MClient_BH.COLUMNNAME_AD_Client_UU + "=? AND " + whereClause, null).setParameters(parameters).first();
			} finally {
				if (Env.getAD_Client_ID(iDempiereContext) == 0) {
					Repository.clearApplyAccessFilterNotNeeded();
				}
			}
		});
	}
}
