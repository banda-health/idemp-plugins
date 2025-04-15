package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StandardResponseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_StandardResponse;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_StandardResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_StandardResponseQuery extends POQuery<X_R_StandardResponse> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_StandardResponse.Table_Name;
	}

	public CompletableFuture<X_R_StandardResponse> R_StandardResponse(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_R_StandardResponse> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_StandardResponseDataLoader.DATALOADER_R_StandardResponse_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_R_StandardResponse> R_StandardResponseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
