package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQLineQtyDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQLineQty;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQLineQtyQuery extends POQuery<MRfQLineQty> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQLineQty.Table_Name;
	}

	public CompletableFuture<MRfQLineQty> C_RfQLineQty(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQLineQty> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQLineQtyDataLoader.DATALOADER_C_RfQLineQty_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQLineQty> C_RfQLineQtyGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
