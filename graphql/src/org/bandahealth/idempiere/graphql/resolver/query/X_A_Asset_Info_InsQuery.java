package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Info_InsDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Info_Ins;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Info_Ins - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Info_InsQuery extends POQuery<X_A_Asset_Info_Ins> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Ins.Table_Name;
	}

	public CompletableFuture<X_A_Asset_Info_Ins> A_Asset_Info_Ins(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Asset_Info_Ins> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Info_InsDataLoader.DATALOADER_A_Asset_Info_Ins_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Asset_Info_Ins> A_Asset_Info_InsGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
