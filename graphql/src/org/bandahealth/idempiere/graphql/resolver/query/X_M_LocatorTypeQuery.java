package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLocatorType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_LocatorType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_LocatorTypeQuery extends POQuery<MLocatorType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLocatorType.Table_Name;
	}

	public CompletableFuture<MLocatorType> M_LocatorType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLocatorType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_LocatorTypeDataLoader.DATALOADER_M_LocatorType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLocatorType> M_LocatorTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
