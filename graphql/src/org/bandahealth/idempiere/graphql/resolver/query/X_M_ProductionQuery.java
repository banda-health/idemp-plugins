package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProduction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Production - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductionQuery extends POQuery<MProduction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProduction.Table_Name;
	}

	public CompletableFuture<MProduction> M_Production(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProduction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductionDataLoader.DATALOADER_M_Production_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProduction> M_ProductionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
