package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_TrainingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_S_Training;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for S_Training - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_TrainingQuery extends POQuery<X_S_Training> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_S_Training.Table_Name;
	}

	public CompletableFuture<X_S_Training> S_Training(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_S_Training> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_S_TrainingDataLoader.DATALOADER_S_Training_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_S_Training> S_TrainingGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
