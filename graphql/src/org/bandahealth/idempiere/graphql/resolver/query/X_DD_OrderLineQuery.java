package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.MDDOrderLine;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for DD_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_DD_OrderLineQuery extends POQuery<MDDOrderLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDDOrderLine.Table_Name;
	}

	public CompletableFuture<MDDOrderLine> DD_OrderLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDDOrderLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_DD_OrderLineDataLoader.DATALOADER_DD_OrderLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDDOrderLine> DD_OrderLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
