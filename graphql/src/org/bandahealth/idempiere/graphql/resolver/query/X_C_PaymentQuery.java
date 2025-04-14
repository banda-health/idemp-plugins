package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PaymentQuery extends POQuery<MPayment_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPayment_BH.Table_Name;
	}

	public CompletableFuture<MPayment_BH> C_Payment(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPayment_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPayment_BH> C_PaymentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
