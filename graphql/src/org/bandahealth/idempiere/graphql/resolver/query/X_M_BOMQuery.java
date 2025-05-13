package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_BOMDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBOM;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_BOMQuery extends POQuery<MBOM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBOM.Table_Name;
	}

	public CompletableFuture<MBOM> M_BOM(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBOM> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_BOMDataLoader.DATALOADER_M_BOM_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBOM> M_BOMGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
