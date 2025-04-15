package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionRunDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionRun;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_DistributionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_DistributionRunQuery extends POQuery<MDistributionRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionRun.Table_Name;
	}

	public CompletableFuture<MDistributionRun> M_DistributionRun(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDistributionRun> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DistributionRunDataLoader.DATALOADER_M_DistributionRun_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDistributionRun> M_DistributionRunGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
