package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LotDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLot;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_LotQuery extends POQuery<MLot> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLot.Table_Name;
	}

	public CompletableFuture<MLot> M_Lot(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLot> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_LotDataLoader.DATALOADER_M_Lot_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLot> M_LotGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
