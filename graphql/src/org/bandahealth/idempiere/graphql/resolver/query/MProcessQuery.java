package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRole;
import org.compiere.util.Env;

import java.util.stream.Collectors;

public class MProcessQuery extends X_AD_ProcessQuery {
	@Override
	public Connection<MProcess_BH> AD_ProcessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		Connection<MProcess_BH> processes = super.Get(page, pageSize, sort, filter, environment);
		// TODO: Update the below to leverage already-existing logic that handles this
		// Only return what the user can see
		MRole usersRole =
				MRole.get(BandaGraphQLContext.getCtx(environment), Env.getAD_Role_ID(BandaGraphQLContext.getCtx(environment)));
		processes.setResults(processes.getResults().stream()
				.filter(process -> usersRole.getProcessAccess(process.getAD_Process_ID()) != null)
				.collect(Collectors.toList()));
		return processes;
	}
}
