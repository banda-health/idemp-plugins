package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_ElementValue;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_ElementValueQuery extends POQuery<X_I_ElementValue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_ElementValue.Table_Name;
	}

	public CompletableFuture<X_I_ElementValue> I_ElementValue(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_ElementValue> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_ElementValueDataLoader.DATALOADER_I_ElementValue_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_ElementValue> I_ElementValueGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
