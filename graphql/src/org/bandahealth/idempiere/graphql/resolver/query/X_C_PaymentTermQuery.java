package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentTerm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PaymentTermQuery extends POQuery<MPaymentTerm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentTerm.Table_Name;
	}

	public CompletableFuture<MPaymentTerm> C_PaymentTerm(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPaymentTerm> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPaymentTerm> C_PaymentTermGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
