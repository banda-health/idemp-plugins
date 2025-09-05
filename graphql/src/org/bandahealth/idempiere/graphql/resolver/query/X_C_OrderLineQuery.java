package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_OrderLineQuery extends POQuery<MOrderLine_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrderLine_BH.Table_Name;
	}

	public CompletableFuture<MOrderLine_BH> C_OrderLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOrderLine_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OrderLineDataLoader.DATALOADER_C_OrderLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOrderLine_BH> C_OrderLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
