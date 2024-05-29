package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_Imp_DetailDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_Imp_Detail;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Package_Imp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Package_Imp_DetailQuery extends POQuery<X_AD_Package_Imp_Detail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Detail.Table_Name;
	}

	public CompletableFuture<X_AD_Package_Imp_Detail> AD_Package_Imp_Detail(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Package_Imp_Detail> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Package_Imp_DetailDataLoader.DATALOADER_AD_Package_Imp_Detail_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Package_Imp_Detail> AD_Package_Imp_DetailGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
