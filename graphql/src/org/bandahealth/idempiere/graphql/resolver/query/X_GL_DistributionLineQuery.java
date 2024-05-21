package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_DistributionLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_DistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_DistributionLineQuery extends POQuery<MDistributionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionLine.Table_Name;
	}

	public CompletableFuture<MDistributionLine> GL_DistributionLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDistributionLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_DistributionLineDataLoader.DATALOADER_GL_DistributionLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDistributionLine> GL_DistributionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
