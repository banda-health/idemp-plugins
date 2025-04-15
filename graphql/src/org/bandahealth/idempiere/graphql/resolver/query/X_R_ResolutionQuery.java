package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_ResolutionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResolution;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_Resolution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_ResolutionQuery extends POQuery<MResolution> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResolution.Table_Name;
	}

	public CompletableFuture<MResolution> R_Resolution(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MResolution> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_ResolutionDataLoader.DATALOADER_R_Resolution_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MResolution> R_ResolutionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
