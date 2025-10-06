package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxPostalDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxPostal;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxPostalQuery extends POQuery<MTaxPostal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxPostal.Table_Name;
	}

	public CompletableFuture<MTaxPostal> C_TaxPostal(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTaxPostal> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxPostalDataLoader.DATALOADER_C_TaxPostal_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTaxPostal> C_TaxPostalGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
