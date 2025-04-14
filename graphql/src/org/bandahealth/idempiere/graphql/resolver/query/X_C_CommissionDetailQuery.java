package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CommissionDetailDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCommissionDetail;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CommissionDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CommissionDetailQuery extends POQuery<MCommissionDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCommissionDetail.Table_Name;
	}

	public CompletableFuture<MCommissionDetail> C_CommissionDetail(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCommissionDetail> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CommissionDetailDataLoader.DATALOADER_C_CommissionDetail_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCommissionDetail> C_CommissionDetailGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
