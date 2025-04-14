package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAccount;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ValidCombination - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_ValidCombinationQuery extends POQuery<MAccount> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAccount.Table_Name;
	}

	public CompletableFuture<MAccount> C_ValidCombination(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAccount> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAccount> C_ValidCombinationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
