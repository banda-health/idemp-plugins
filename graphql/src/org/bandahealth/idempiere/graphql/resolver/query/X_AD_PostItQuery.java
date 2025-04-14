package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PostItDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPostIt;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PostIt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PostItQuery extends POQuery<MPostIt> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPostIt.Table_Name;
	}

	public CompletableFuture<MPostIt> AD_PostIt(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPostIt> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PostItDataLoader.DATALOADER_AD_PostIt_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPostIt> AD_PostItGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
