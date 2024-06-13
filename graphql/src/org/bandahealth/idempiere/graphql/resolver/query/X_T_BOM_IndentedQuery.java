package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_BOM_IndentedDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_BOM_Indented;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_BOM_Indented - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_BOM_IndentedQuery extends POQuery<X_T_BOM_Indented> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_BOM_Indented.Table_Name;
	}

	public CompletableFuture<X_T_BOM_Indented> T_BOM_Indented(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_BOM_Indented> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_BOM_IndentedDataLoader.DATALOADER_T_BOM_Indented_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_BOM_Indented> T_BOM_IndentedGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
