package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxProviderCfgDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_TaxProviderCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxProviderCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxProviderCfgQuery extends POQuery<X_C_TaxProviderCfg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxProviderCfg.Table_Name;
	}

	public CompletableFuture<X_C_TaxProviderCfg> C_TaxProviderCfg(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_TaxProviderCfg> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxProviderCfgDataLoader.DATALOADER_C_TaxProviderCfg_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_TaxProviderCfg> C_TaxProviderCfgGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
