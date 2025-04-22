package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQResponseLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQResponseLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQResponseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQResponseLineQuery extends POQuery<MRfQResponseLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQResponseLine.Table_Name;
	}

	public CompletableFuture<MRfQResponseLine> C_RfQResponseLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQResponseLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQResponseLineDataLoader.DATALOADER_C_RfQResponseLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQResponseLine> C_RfQResponseLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
