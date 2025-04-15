package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingTransactionLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShippingTransactionLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShippingTransactionLineQuery extends POQuery<MShippingTransactionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShippingTransactionLine.Table_Name;
	}

	public CompletableFuture<MShippingTransactionLine> M_ShippingTransactionLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MShippingTransactionLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ShippingTransactionLineDataLoader.DATALOADER_M_ShippingTransactionLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MShippingTransactionLine> M_ShippingTransactionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
