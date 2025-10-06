package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentProcessorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentProcessor;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PaymentProcessorQuery extends POQuery<MPaymentProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentProcessor.Table_Name;
	}

	public CompletableFuture<MPaymentProcessor> C_PaymentProcessor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPaymentProcessor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaymentProcessorDataLoader.DATALOADER_C_PaymentProcessor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPaymentProcessor> C_PaymentProcessorGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
