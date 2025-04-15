package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_HierarchyDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MHierarchy;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_HierarchyQuery extends POQuery<MHierarchy> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MHierarchy.Table_Name;
	}

	public CompletableFuture<MHierarchy> PA_Hierarchy(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MHierarchy> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_HierarchyDataLoader.DATALOADER_PA_Hierarchy_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MHierarchy> PA_HierarchyGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
