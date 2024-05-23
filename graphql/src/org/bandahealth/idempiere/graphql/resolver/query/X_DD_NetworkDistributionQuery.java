package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_NetworkDistributionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_DD_NetworkDistribution;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for DD_NetworkDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_DD_NetworkDistributionQuery extends POQuery<X_DD_NetworkDistribution> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_DD_NetworkDistribution.Table_Name;
	}

	public CompletableFuture<X_DD_NetworkDistribution> DD_NetworkDistribution(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_DD_NetworkDistribution> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_DD_NetworkDistributionDataLoader.DATALOADER_DD_NetworkDistribution_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_DD_NetworkDistribution> DD_NetworkDistributionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
