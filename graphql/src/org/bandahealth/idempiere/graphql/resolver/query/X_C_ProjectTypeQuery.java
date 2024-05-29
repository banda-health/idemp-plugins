package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectTypeQuery extends POQuery<MProjectType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectType.Table_Name;
	}

	public CompletableFuture<MProjectType> C_ProjectType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProjectType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ProjectTypeDataLoader.DATALOADER_C_ProjectType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProjectType> C_ProjectTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
