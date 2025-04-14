package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionListLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionListLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_DistributionListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DistributionListLineQuery extends POQuery<MDistributionListLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionListLine.Table_Name;
	}

	public CompletableFuture<MDistributionListLine> M_DistributionListLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDistributionListLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DistributionListLineDataLoader.DATALOADER_M_DistributionListLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDistributionListLine> M_DistributionListLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
