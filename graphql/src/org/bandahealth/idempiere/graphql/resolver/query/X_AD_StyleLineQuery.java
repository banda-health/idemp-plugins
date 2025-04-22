package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_StyleLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStyleLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_StyleLineQuery extends POQuery<MStyleLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStyleLine.Table_Name;
	}

	public CompletableFuture<MStyleLine> AD_StyleLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStyleLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_StyleLineDataLoader.DATALOADER_AD_StyleLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStyleLine> AD_StyleLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
