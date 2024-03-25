package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MHierarchy;

/**
 * Generated Query Resolver for PA_Hierarchy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_HierarchyQuery extends POQuery<MHierarchy> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MHierarchy.Table_Name;
	}

	public Connection<MHierarchy> PA_HierarchyGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
