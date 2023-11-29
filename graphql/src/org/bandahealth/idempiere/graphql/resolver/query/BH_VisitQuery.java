package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.compiere.model.MRole;
import org.compiere.util.Env;

import java.util.concurrent.CompletableFuture;

public class BH_VisitQuery implements GraphQLQueryResolver {
	public CompletableFuture<MBHVisit> BH_VisitGet(int page, int pageSize, String filter, String sort,
			DataFetchingEnvironment environment) {
		if (MRole.get(BandaGraphQLContext.getCtx(environment), Env.getAD_Role_ID(BandaGraphQLContext.getCtx(environment))).getwin)
		return CompletableFuture.supplyAsync(() ->
				repository.get(MBHVisit.Table_Name, filter, sort, new PagingInfo(page, pageSize), environment));
	}
}
