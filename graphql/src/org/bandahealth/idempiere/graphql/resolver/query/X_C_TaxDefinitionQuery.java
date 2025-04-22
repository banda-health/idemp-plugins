package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDefinitionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxDefinition;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxDefinitionQuery extends POQuery<X_C_TaxDefinition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxDefinition.Table_Name;
	}

	public CompletableFuture<X_C_TaxDefinition> C_TaxDefinition(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_TaxDefinition> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxDefinitionDataLoader.DATALOADER_C_TaxDefinition_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_TaxDefinition> C_TaxDefinitionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
