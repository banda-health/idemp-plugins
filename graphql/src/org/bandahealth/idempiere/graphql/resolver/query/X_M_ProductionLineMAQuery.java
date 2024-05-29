package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionLineMADataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductionLineMA;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ProductionLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductionLineMAQuery extends POQuery<MProductionLineMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductionLineMA.Table_Name;
	}

	public CompletableFuture<MProductionLineMA> M_ProductionLineMA(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProductionLineMA> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductionLineMADataLoader.DATALOADER_M_ProductionLineMA_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProductionLineMA> M_ProductionLineMAGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
