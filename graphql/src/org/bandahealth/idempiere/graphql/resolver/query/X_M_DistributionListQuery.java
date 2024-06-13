package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionListDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionList;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_DistributionList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DistributionListQuery extends POQuery<MDistributionList> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionList.Table_Name;
	}

	public CompletableFuture<MDistributionList> M_DistributionList(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDistributionList> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DistributionListDataLoader.DATALOADER_M_DistributionList_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDistributionList> M_DistributionListGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
