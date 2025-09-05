package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentAllocateDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentAllocate;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PaymentAllocateQuery extends POQuery<MPaymentAllocate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentAllocate.Table_Name;
	}

	public CompletableFuture<MPaymentAllocate> C_PaymentAllocate(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPaymentAllocate> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaymentAllocateDataLoader.DATALOADER_C_PaymentAllocate_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPaymentAllocate> C_PaymentAllocateGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
