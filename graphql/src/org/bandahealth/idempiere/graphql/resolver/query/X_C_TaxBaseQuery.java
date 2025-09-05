package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxBaseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxBaseQuery extends POQuery<X_C_TaxBase> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxBase.Table_Name;
	}

	public CompletableFuture<X_C_TaxBase> C_TaxBase(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_TaxBase> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxBaseDataLoader.DATALOADER_C_TaxBase_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_TaxBase> C_TaxBaseGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
