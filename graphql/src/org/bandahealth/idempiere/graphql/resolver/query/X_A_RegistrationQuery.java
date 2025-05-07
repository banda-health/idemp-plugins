package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Registration;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationQuery extends POQuery<X_A_Registration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Registration.Table_Name;
	}

	public CompletableFuture<X_A_Registration> A_Registration(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Registration> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_RegistrationDataLoader.DATALOADER_A_Registration_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Registration> A_RegistrationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
