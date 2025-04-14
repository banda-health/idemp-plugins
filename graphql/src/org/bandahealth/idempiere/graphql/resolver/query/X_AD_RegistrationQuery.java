package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RegistrationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.M_Registration;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_RegistrationQuery extends POQuery<M_Registration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return M_Registration.Table_Name;
	}

	public CompletableFuture<M_Registration> AD_Registration(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, M_Registration> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_RegistrationDataLoader.DATALOADER_AD_Registration_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<M_Registration> AD_RegistrationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
