package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_NetworkDistributionLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_DD_NetworkDistributionLine;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for DD_NetworkDistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_DD_NetworkDistributionLineQuery extends POQuery<X_DD_NetworkDistributionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_DD_NetworkDistributionLine.Table_Name;
	}

	public CompletableFuture<X_DD_NetworkDistributionLine> DD_NetworkDistributionLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_DD_NetworkDistributionLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_DD_NetworkDistributionLineDataLoader.DATALOADER_DD_NetworkDistributionLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_DD_NetworkDistributionLine> DD_NetworkDistributionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
