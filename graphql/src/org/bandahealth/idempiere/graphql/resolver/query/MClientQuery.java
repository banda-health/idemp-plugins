package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MClientQuery extends X_AD_ClientQuery {
	@Override
	public Connection<MClient_BH> AD_ClientGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		Properties iDempiereContext = BandaGraphQLContext.getCtx(environment);
		// If the user is currently the system client, we can get everything
		if (Env.getAD_Client_ID(iDempiereContext) == 0) {
			Repository.setApplyAccessFilterNotNeeded();
		}
		var clients = super.AD_ClientGet(page, pageSize, sort, filter, environment);
		if (Env.getAD_Client_ID(iDempiereContext) == 0) {
			Repository.clearApplyAccessFilterNotNeeded();
			// If the user isn't the super user, limit what they can see
			if (!MUser_BH.get(iDempiereContext).isAdministrator()) {
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
				List<Integer> clientIdsForUser = new ArrayList<>();
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
				clients.setResults(
						clients.getResults().stream().filter(client -> clientIdsForUser.contains(client.get_ID())).toList());
			}
		}
		return clients;
	}
}
