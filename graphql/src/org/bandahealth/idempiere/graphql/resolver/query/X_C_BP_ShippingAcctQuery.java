package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_ShippingAcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_BP_ShippingAcct;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BP_ShippingAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BP_ShippingAcctQuery extends POQuery<X_C_BP_ShippingAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_ShippingAcct.Table_Name;
	}

	public CompletableFuture<X_C_BP_ShippingAcct> C_BP_ShippingAcct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_BP_ShippingAcct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BP_ShippingAcctDataLoader.DATALOADER_C_BP_ShippingAcct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_BP_ShippingAcct> C_BP_ShippingAcctGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
