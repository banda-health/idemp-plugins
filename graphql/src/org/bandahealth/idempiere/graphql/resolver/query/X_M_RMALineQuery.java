package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMALineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRMALine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RMALineQuery extends POQuery<MRMALine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRMALine.Table_Name;
	}

	public CompletableFuture<MRMALine> M_RMALine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRMALine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_RMALineDataLoader.DATALOADER_M_RMALine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRMALine> M_RMALineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
