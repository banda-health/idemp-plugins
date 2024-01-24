package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecurring;

/**
 * Generated Query Resolver for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RecurringQuery extends POQuery<MRecurring> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecurring.Table_Name;
	}

	public Connection<MRecurring> C_RecurringGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
