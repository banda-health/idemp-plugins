package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceBatchLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceBatchLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_InvoiceBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceBatchLineQuery extends POQuery<MInvoiceBatchLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceBatchLine.Table_Name;
	}

	public CompletableFuture<MInvoiceBatchLine> C_InvoiceBatchLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInvoiceBatchLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_InvoiceBatchLineDataLoader.DATALOADER_C_InvoiceBatchLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInvoiceBatchLine> C_InvoiceBatchLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
