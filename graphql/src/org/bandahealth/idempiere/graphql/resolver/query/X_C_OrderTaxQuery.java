package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderTaxDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrderTax;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_OrderTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OrderTaxQuery extends POQuery<MOrderTax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrderTax.Table_Name;
	}

	public CompletableFuture<MOrderTax> C_OrderTax(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOrderTax> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OrderTaxDataLoader.DATALOADER_C_OrderTax_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOrderTax> C_OrderTaxGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
