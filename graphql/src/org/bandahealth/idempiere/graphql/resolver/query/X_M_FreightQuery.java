package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_FreightDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFreight;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_FreightQuery extends POQuery<MFreight> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFreight.Table_Name;
	}

	public CompletableFuture<MFreight> M_Freight(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MFreight> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_FreightDataLoader.DATALOADER_M_Freight_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MFreight> M_FreightGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
