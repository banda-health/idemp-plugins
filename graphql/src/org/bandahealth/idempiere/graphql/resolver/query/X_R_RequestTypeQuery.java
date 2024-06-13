package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestTypeQuery extends POQuery<MRequestType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestType.Table_Name;
	}

	public CompletableFuture<MRequestType> R_RequestType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequestType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_RequestTypeDataLoader.DATALOADER_R_RequestType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequestType> R_RequestTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
