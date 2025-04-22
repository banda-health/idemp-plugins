package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RfQLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_RfQLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQLineQuery extends POQuery<MRfQLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQLine.Table_Name;
	}

	public CompletableFuture<MRfQLine> C_RfQLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRfQLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RfQLineDataLoader.DATALOADER_C_RfQLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRfQLine> C_RfQLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
