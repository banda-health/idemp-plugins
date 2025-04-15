package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_FormatLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPFormatLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_EXP_FormatLineQuery extends POQuery<MEXPFormatLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPFormatLine.Table_Name;
	}

	public CompletableFuture<MEXPFormatLine> EXP_FormatLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MEXPFormatLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_EXP_FormatLineDataLoader.DATALOADER_EXP_FormatLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MEXPFormatLine> EXP_FormatLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
