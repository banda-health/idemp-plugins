package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_RegistrationProductDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_RegistrationProduct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_RegistrationProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_RegistrationProductQuery extends POQuery<X_A_RegistrationProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationProduct.Table_Name;
	}

	public CompletableFuture<X_A_RegistrationProduct> A_RegistrationProduct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_RegistrationProduct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_RegistrationProductDataLoader.DATALOADER_A_RegistrationProduct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_RegistrationProduct> A_RegistrationProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
