package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ListLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_ListLine;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListLineQuery extends POQuery<X_HR_ListLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListLine.Table_Name;
	}

	public CompletableFuture<X_HR_ListLine> HR_ListLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_ListLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_ListLineDataLoader.DATALOADER_HR_ListLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_ListLine> HR_ListLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
