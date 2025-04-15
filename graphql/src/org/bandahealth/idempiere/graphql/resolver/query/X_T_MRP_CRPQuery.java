package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_MRP_CRPDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_T_MRP_CRP;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_MRP_CRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_MRP_CRPQuery extends POQuery<X_T_MRP_CRP> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_MRP_CRP.Table_Name;
	}

	public CompletableFuture<X_T_MRP_CRP> T_MRP_CRP(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_MRP_CRP> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_MRP_CRPDataLoader.DATALOADER_T_MRP_CRP_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_MRP_CRP> T_MRP_CRPGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
