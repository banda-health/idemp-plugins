package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AddressValidationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAddressValidation;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AddressValidationQuery extends POQuery<MAddressValidation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAddressValidation.Table_Name;
	}

	public CompletableFuture<MAddressValidation> C_AddressValidation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAddressValidation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AddressValidationDataLoader.DATALOADER_C_AddressValidation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAddressValidation> C_AddressValidationGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
