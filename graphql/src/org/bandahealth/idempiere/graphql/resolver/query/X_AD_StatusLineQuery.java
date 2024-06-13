package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StatusLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStatusLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_StatusLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_StatusLineQuery extends POQuery<MStatusLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStatusLine.Table_Name;
	}

	public CompletableFuture<MStatusLine> AD_StatusLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStatusLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_StatusLineDataLoader.DATALOADER_AD_StatusLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStatusLine> AD_StatusLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
