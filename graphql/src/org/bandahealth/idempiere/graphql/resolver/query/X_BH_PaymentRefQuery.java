package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_PaymentRefDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_PaymentRef - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_PaymentRefQuery extends POQuery<MBHPaymentRef> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPaymentRef.Table_Name;
	}

	public CompletableFuture<MBHPaymentRef> BH_PaymentRef(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPaymentRef> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_PaymentRefDataLoader.DATALOADER_BH_PaymentRef_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPaymentRef> BH_PaymentRefGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
