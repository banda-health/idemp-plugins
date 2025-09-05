package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQResponseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQResponse;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQResponseQuery extends POQuery<MRfQResponse> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQResponse.Table_Name;
	}

	public CompletableFuture<MRfQResponse> C_RfQResponse(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQResponse> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQResponseDataLoader.DATALOADER_C_RfQResponse_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQResponse> C_RfQResponseGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
