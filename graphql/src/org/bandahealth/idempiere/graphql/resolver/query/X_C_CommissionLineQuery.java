package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CommissionLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommissionLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CommissionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CommissionLineQuery extends POQuery<MCommissionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommissionLine.Table_Name;
	}

	public CompletableFuture<MCommissionLine> C_CommissionLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCommissionLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CommissionLineDataLoader.DATALOADER_C_CommissionLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCommissionLine> C_CommissionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
