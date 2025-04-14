package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceAssignmentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResourceAssignment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for S_ResourceAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_S_ResourceAssignmentQuery extends POQuery<MResourceAssignment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResourceAssignment.Table_Name;
	}

	public CompletableFuture<MResourceAssignment> S_ResourceAssignment(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MResourceAssignment> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_S_ResourceAssignmentDataLoader.DATALOADER_S_ResourceAssignment_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MResourceAssignment> S_ResourceAssignmentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
