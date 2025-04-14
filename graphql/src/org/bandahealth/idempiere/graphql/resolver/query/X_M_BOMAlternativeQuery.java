package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_BOMAlternativeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_BOMAlternative;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_BOMAlternative - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_BOMAlternativeQuery extends POQuery<X_M_BOMAlternative> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_BOMAlternative.Table_Name;
	}

	public CompletableFuture<X_M_BOMAlternative> M_BOMAlternative(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_BOMAlternative> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_BOMAlternativeDataLoader.DATALOADER_M_BOMAlternative_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_BOMAlternative> M_BOMAlternativeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
