package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_DistributionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistribution;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_Distribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_DistributionQuery extends POQuery<MDistribution> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistribution.Table_Name;
	}

	public CompletableFuture<MDistribution> GL_Distribution(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDistribution> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_DistributionDataLoader.DATALOADER_GL_Distribution_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDistribution> GL_DistributionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
