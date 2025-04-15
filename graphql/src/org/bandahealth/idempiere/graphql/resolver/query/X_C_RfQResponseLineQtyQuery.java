package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQResponseLineQtyDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQResponseLineQty;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQResponseLineQtyQuery extends POQuery<MRfQResponseLineQty> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQResponseLineQty.Table_Name;
	}

	public CompletableFuture<MRfQResponseLineQty> C_RfQResponseLineQty(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQResponseLineQty> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQResponseLineQtyDataLoader.DATALOADER_C_RfQResponseLineQty_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQResponseLineQty> C_RfQResponseLineQtyGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
