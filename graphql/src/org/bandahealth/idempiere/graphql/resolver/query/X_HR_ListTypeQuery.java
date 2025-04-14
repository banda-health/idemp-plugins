package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ListTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_ListType;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_ListType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_ListTypeQuery extends POQuery<X_HR_ListType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListType.Table_Name;
	}

	public CompletableFuture<X_HR_ListType> HR_ListType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_ListType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_ListTypeDataLoader.DATALOADER_HR_ListType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_ListType> HR_ListTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
