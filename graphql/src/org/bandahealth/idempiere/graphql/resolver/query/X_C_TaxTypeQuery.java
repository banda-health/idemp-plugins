package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxType;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxTypeQuery extends POQuery<X_C_TaxType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxType.Table_Name;
	}

	public CompletableFuture<X_C_TaxType> C_TaxType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_TaxType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxTypeDataLoader.DATALOADER_C_TaxType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_TaxType> C_TaxTypeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
