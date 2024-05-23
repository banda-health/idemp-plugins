package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintLabelLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_PrintLabelLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PrintLabelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintLabelLineQuery extends POQuery<X_AD_PrintLabelLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintLabelLine.Table_Name;
	}

	public CompletableFuture<X_AD_PrintLabelLine> AD_PrintLabelLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_PrintLabelLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintLabelLineDataLoader.DATALOADER_AD_PrintLabelLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_PrintLabelLine> AD_PrintLabelLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
