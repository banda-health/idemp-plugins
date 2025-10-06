package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationAttributeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_RegistrationAttribute;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_RegistrationAttribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationAttributeQuery extends POQuery<X_A_RegistrationAttribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationAttribute.Table_Name;
	}

	public CompletableFuture<X_A_RegistrationAttribute> A_RegistrationAttribute(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_RegistrationAttribute> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_RegistrationAttributeDataLoader.DATALOADER_A_RegistrationAttribute_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_RegistrationAttribute> A_RegistrationAttributeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
