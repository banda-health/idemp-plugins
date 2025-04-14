package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrgAssignmentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_OrgAssignment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_OrgAssignment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OrgAssignmentQuery extends POQuery<X_C_OrgAssignment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_OrgAssignment.Table_Name;
	}

	public CompletableFuture<X_C_OrgAssignment> C_OrgAssignment(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_OrgAssignment> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OrgAssignmentDataLoader.DATALOADER_C_OrgAssignment_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_OrgAssignment> C_OrgAssignmentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
