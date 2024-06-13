package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CommissionAmtDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommissionAmt;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CommissionAmt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CommissionAmtQuery extends POQuery<MCommissionAmt> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommissionAmt.Table_Name;
	}

	public CompletableFuture<MCommissionAmt> C_CommissionAmt(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCommissionAmt> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CommissionAmtDataLoader.DATALOADER_C_CommissionAmt_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCommissionAmt> C_CommissionAmtGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
