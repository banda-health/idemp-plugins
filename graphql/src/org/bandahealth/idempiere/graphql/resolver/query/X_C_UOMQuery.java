package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_UOMQuery extends POQuery<MUOM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUOM.Table_Name;
	}

	public CompletableFuture<MUOM> C_UOM(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUOM> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUOM> C_UOMGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
