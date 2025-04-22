package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserBPAccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserBPAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_UserBPAccessQuery extends POQuery<MUserBPAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserBPAccess.Table_Name;
	}

	public CompletableFuture<MUserBPAccess> AD_UserBPAccess(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserBPAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserBPAccessDataLoader.DATALOADER_AD_UserBPAccess_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserBPAccess> AD_UserBPAccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
