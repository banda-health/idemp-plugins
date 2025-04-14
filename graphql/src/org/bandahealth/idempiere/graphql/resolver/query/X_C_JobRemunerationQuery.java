package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_JobRemunerationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_JobRemuneration;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_JobRemunerationQuery extends POQuery<X_C_JobRemuneration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_JobRemuneration.Table_Name;
	}

	public CompletableFuture<X_C_JobRemuneration> C_JobRemuneration(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_JobRemuneration> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_JobRemunerationDataLoader.DATALOADER_C_JobRemuneration_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_JobRemuneration> C_JobRemunerationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
