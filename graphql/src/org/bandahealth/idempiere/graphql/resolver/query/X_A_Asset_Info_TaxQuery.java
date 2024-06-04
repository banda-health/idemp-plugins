package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Info_TaxDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Info_Tax;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Info_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Info_TaxQuery extends POQuery<X_A_Asset_Info_Tax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Tax.Table_Name;
	}

	public CompletableFuture<X_A_Asset_Info_Tax> A_Asset_Info_Tax(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Asset_Info_Tax> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Info_TaxDataLoader.DATALOADER_A_Asset_Info_Tax_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Asset_Info_Tax> A_Asset_Info_TaxGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
