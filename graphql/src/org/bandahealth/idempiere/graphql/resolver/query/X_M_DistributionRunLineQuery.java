package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DistributionRunLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionRunLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DistributionRunLineQuery extends POQuery<MDistributionRunLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionRunLine.Table_Name;
	}

	public CompletableFuture<MDistributionRunLine> M_DistributionRunLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDistributionRunLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DistributionRunLineDataLoader.DATALOADER_M_DistributionRunLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDistributionRunLine> M_DistributionRunLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
