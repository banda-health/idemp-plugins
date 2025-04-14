package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Info_LicDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Info_Lic;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Info_Lic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_Info_LicQuery extends POQuery<X_A_Asset_Info_Lic> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Lic.Table_Name;
	}

	public CompletableFuture<X_A_Asset_Info_Lic> A_Asset_Info_Lic(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Asset_Info_Lic> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Info_LicDataLoader.DATALOADER_A_Asset_Info_Lic_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Asset_Info_Lic> A_Asset_Info_LicGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
