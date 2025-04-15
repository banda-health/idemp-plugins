package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_Fact_ReconciliationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFactReconciliation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_Fact_ReconciliationQuery extends POQuery<MFactReconciliation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFactReconciliation.Table_Name;
	}

	public CompletableFuture<MFactReconciliation> Fact_Reconciliation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MFactReconciliation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_Fact_ReconciliationDataLoader.DATALOADER_Fact_Reconciliation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MFactReconciliation> Fact_ReconciliationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
