package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceBatchDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceBatch;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_InvoiceBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_InvoiceBatchQuery extends POQuery<MInvoiceBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceBatch.Table_Name;
	}

	public CompletableFuture<MInvoiceBatch> C_InvoiceBatch(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInvoiceBatch> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_InvoiceBatchDataLoader.DATALOADER_C_InvoiceBatch_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInvoiceBatch> C_InvoiceBatchGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
