package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Info_FinDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Info_Fin;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_Info_FinQuery extends POQuery<X_A_Asset_Info_Fin> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Fin.Table_Name;
	}

	public CompletableFuture<X_A_Asset_Info_Fin> A_Asset_Info_Fin(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Asset_Info_Fin> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Info_FinDataLoader.DATALOADER_A_Asset_Info_Fin_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Asset_Info_Fin> A_Asset_Info_FinGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
