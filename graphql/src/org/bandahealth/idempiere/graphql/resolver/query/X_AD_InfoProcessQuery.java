package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoProcessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_InfoProcess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_InfoProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoProcessQuery extends POQuery<X_AD_InfoProcess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoProcess.Table_Name;
	}

	public CompletableFuture<X_AD_InfoProcess> AD_InfoProcess(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_InfoProcess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_InfoProcessDataLoader.DATALOADER_AD_InfoProcess_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_InfoProcess> AD_InfoProcessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
