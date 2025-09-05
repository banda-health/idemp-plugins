package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_DistributionRunDetailDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionRunDetail;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_DistributionRunDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_DistributionRunDetailQuery extends POQuery<MDistributionRunDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionRunDetail.Table_Name;
	}

	public CompletableFuture<MDistributionRunDetail> T_DistributionRunDetail(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDistributionRunDetail> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_DistributionRunDetailDataLoader.DATALOADER_T_DistributionRunDetail_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDistributionRunDetail> T_DistributionRunDetailGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
