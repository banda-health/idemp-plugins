package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceScheduleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceSchedule;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_InvoiceScheduleQuery extends POQuery<MInvoiceSchedule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceSchedule.Table_Name;
	}

	public CompletableFuture<MInvoiceSchedule> C_InvoiceSchedule(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInvoiceSchedule> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_InvoiceScheduleDataLoader.DATALOADER_C_InvoiceSchedule_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInvoiceSchedule> C_InvoiceScheduleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
