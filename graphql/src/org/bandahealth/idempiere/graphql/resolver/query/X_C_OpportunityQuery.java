package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OpportunityDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOpportunity;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Opportunity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_OpportunityQuery extends POQuery<MOpportunity> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOpportunity.Table_Name;
	}

	public CompletableFuture<MOpportunity> C_Opportunity(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOpportunity> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OpportunityDataLoader.DATALOADER_C_Opportunity_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOpportunity> C_OpportunityGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
