package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceTaxDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceTax;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_InvoiceTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_InvoiceTaxQuery extends POQuery<MInvoiceTax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceTax.Table_Name;
	}

	public CompletableFuture<MInvoiceTax> C_InvoiceTax(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInvoiceTax> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_InvoiceTaxDataLoader.DATALOADER_C_InvoiceTax_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInvoiceTax> C_InvoiceTaxGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
