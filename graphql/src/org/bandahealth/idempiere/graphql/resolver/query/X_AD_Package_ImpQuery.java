package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_ImpDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_Imp;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Package_Imp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Package_ImpQuery extends POQuery<X_AD_Package_Imp> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp.Table_Name;
	}

	public CompletableFuture<X_AD_Package_Imp> AD_Package_Imp(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Package_Imp> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Package_ImpDataLoader.DATALOADER_AD_Package_Imp_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Package_Imp> AD_Package_ImpGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
