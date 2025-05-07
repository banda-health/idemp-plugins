package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRegistration;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationQuery extends POQuery<MRegistration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRegistration.Table_Name;
	}

	public CompletableFuture<MRegistration> A_Registration(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRegistration> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_RegistrationDataLoader.DATALOADER_A_Registration_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRegistration> A_RegistrationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
