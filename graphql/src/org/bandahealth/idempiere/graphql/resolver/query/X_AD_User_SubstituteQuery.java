package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_User_SubstituteDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_User_Substitute;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_User_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_User_SubstituteQuery extends POQuery<X_AD_User_Substitute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_User_Substitute.Table_Name;
	}

	public CompletableFuture<X_AD_User_Substitute> AD_User_Substitute(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_User_Substitute> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_User_SubstituteDataLoader.DATALOADER_AD_User_Substitute_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_User_Substitute> AD_User_SubstituteGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
