package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.util.Env;

public class MClientQuery extends X_AD_ClientQuery {
	@Override
	public Connection<MClient_BH> AD_ClientGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		// If the user is currently the system client, we can get everything
		if (Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)) == 0) {
			Repository.setApplyAccessFilterNotNeeded();
		}
		var clients = super.AD_ClientGet(page, pageSize, sort, filter, environment);
		if (Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)) == 0) {
			Repository.clearApplyAccessFilterNotNeeded();
		}
		return clients;
	}
}
