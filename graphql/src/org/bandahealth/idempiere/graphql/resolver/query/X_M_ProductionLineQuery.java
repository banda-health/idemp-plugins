package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductionLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ProductionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ProductionLineQuery extends POQuery<MProductionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductionLine.Table_Name;
	}

	public CompletableFuture<MProductionLine> M_ProductionLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProductionLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductionLineDataLoader.DATALOADER_M_ProductionLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProductionLine> M_ProductionLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
