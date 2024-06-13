package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MElement;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ElementQuery extends POQuery<MElement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MElement.Table_Name;
	}

	public CompletableFuture<MElement> C_Element(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MElement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ElementDataLoader.DATALOADER_C_Element_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MElement> C_ElementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
