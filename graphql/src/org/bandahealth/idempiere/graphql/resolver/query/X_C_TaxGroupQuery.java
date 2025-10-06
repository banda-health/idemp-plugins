package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxGroupDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxGroup;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxGroupQuery extends POQuery<X_C_TaxGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxGroup.Table_Name;
	}

	public CompletableFuture<X_C_TaxGroup> C_TaxGroup(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_TaxGroup> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxGroupDataLoader.DATALOADER_C_TaxGroup_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_TaxGroup> C_TaxGroupGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
