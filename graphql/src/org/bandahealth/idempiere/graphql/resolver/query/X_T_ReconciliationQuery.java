package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_ReconciliationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_Reconciliation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_T_ReconciliationQuery extends POQuery<X_T_Reconciliation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_Reconciliation.Table_Name;
	}

	public CompletableFuture<X_T_Reconciliation> T_Reconciliation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_Reconciliation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_ReconciliationDataLoader.DATALOADER_T_Reconciliation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_Reconciliation> T_ReconciliationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
