package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_FormatDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPFormat;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for EXP_Format - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_EXP_FormatQuery extends POQuery<MEXPFormat> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPFormat.Table_Name;
	}

	public CompletableFuture<MEXPFormat> EXP_Format(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MEXPFormat> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_EXP_FormatDataLoader.DATALOADER_EXP_Format_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MEXPFormat> EXP_FormatGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
