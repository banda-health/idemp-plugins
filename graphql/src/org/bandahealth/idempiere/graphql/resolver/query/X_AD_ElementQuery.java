package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ElementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.M_Element;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ElementQuery extends POQuery<M_Element> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return M_Element.Table_Name;
	}

	public CompletableFuture<M_Element> AD_Element(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, M_Element> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ElementDataLoader.DATALOADER_AD_Element_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<M_Element> AD_ElementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
