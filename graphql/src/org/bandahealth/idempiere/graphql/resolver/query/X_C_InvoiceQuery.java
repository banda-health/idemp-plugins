package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceQuery extends POQuery<MInvoice_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoice_BH.Table_Name;
	}

	public CompletableFuture<MInvoice_BH> C_Invoice(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInvoice_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInvoice_BH> C_InvoiceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
