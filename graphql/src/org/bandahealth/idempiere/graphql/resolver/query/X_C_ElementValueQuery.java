package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MElementValue;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ElementValueQuery extends POQuery<MElementValue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MElementValue.Table_Name;
	}

	public CompletableFuture<MElementValue> C_ElementValue(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MElementValue> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MElementValue> C_ElementValueGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
