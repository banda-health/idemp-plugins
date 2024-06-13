package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserQuery extends POQuery<MUser_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUser_BH.Table_Name;
	}

	public CompletableFuture<MUser_BH> AD_User(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUser_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUser_BH> AD_UserGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
