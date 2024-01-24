package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_RecurringGroup;

/**
 * Generated Query Resolver for C_RecurringGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RecurringGroupQuery extends POQuery<X_C_RecurringGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_RecurringGroup.Table_Name;
	}

	public Connection<X_C_RecurringGroup> C_RecurringGroupGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
