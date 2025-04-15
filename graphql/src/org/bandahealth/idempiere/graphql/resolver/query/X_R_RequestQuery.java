package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequest;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_RequestQuery extends POQuery<MRequest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequest.Table_Name;
	}

	public CompletableFuture<MRequest> R_Request(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequest> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_RequestDataLoader.DATALOADER_R_Request_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequest> R_RequestGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
