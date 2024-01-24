package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecurringRun;

/**
 * Generated Query Resolver for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_Recurring_RunQuery extends POQuery<MRecurringRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecurringRun.Table_Name;
	}

	public Connection<MRecurringRun> C_Recurring_RunGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
