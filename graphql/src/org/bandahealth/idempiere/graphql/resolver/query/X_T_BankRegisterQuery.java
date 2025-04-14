package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_BankRegisterDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_BankRegister;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_BankRegister - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_T_BankRegisterQuery extends POQuery<X_T_BankRegister> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_BankRegister.Table_Name;
	}

	public CompletableFuture<X_T_BankRegister> T_BankRegister(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_BankRegister> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_BankRegisterDataLoader.DATALOADER_T_BankRegister_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_BankRegister> T_BankRegisterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
