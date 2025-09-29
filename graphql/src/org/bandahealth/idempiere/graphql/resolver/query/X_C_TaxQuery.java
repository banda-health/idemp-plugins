package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTax;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxQuery extends POQuery<MTax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTax.Table_Name;
	}

	public CompletableFuture<MTax> C_Tax(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTax> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTax> C_TaxGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
