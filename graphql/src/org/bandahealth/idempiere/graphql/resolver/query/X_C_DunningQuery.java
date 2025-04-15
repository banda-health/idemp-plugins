package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDunning;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Dunning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DunningQuery extends POQuery<MDunning> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDunning.Table_Name;
	}

	public CompletableFuture<MDunning> C_Dunning(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDunning> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DunningDataLoader.DATALOADER_C_Dunning_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDunning> C_DunningGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
