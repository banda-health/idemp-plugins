package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationAttributeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRegistrationAttribute;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_RegistrationAttribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationAttributeQuery extends POQuery<MRegistrationAttribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRegistrationAttribute.Table_Name;
	}

	public CompletableFuture<MRegistrationAttribute> A_RegistrationAttribute(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRegistrationAttribute> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_RegistrationAttributeDataLoader.DATALOADER_A_RegistrationAttribute_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRegistrationAttribute> A_RegistrationAttributeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
