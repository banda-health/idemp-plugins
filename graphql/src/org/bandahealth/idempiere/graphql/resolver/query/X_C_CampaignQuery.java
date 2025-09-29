package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCampaign;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CampaignQuery extends POQuery<MCampaign> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCampaign.Table_Name;
	}

	public CompletableFuture<MCampaign> C_Campaign(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCampaign> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCampaign> C_CampaignGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
