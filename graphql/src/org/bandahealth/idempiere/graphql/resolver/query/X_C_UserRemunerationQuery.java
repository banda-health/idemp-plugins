package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UserRemunerationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_UserRemuneration;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_UserRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_UserRemunerationQuery extends POQuery<X_C_UserRemuneration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_UserRemuneration.Table_Name;
	}

	public CompletableFuture<X_C_UserRemuneration> C_UserRemuneration(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_UserRemuneration> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_UserRemunerationDataLoader.DATALOADER_C_UserRemuneration_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_UserRemuneration> C_UserRemunerationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
