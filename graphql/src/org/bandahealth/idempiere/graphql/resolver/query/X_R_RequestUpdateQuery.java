package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestUpdateDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestUpdate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestUpdateQuery extends POQuery<MRequestUpdate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestUpdate.Table_Name;
	}

	public CompletableFuture<MRequestUpdate> R_RequestUpdate(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequestUpdate> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_RequestUpdateDataLoader.DATALOADER_R_RequestUpdate_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequestUpdate> R_RequestUpdateGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
