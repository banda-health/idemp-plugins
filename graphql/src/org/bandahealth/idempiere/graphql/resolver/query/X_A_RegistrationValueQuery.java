package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationValueDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRegistrationValue;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationValueQuery extends POQuery<MRegistrationValue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRegistrationValue.Table_Name;
	}

	public CompletableFuture<MRegistrationValue> A_RegistrationValue(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRegistrationValue> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_RegistrationValueDataLoader.DATALOADER_A_RegistrationValue_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRegistrationValue> A_RegistrationValueGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
