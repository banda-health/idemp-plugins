package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ContractDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Contract;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Contract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_ContractQuery extends POQuery<X_HR_Contract> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Contract.Table_Name;
	}

	public CompletableFuture<X_HR_Contract> HR_Contract(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Contract> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_ContractDataLoader.DATALOADER_HR_Contract_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Contract> HR_ContractGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
