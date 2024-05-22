package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecurring;

/**
 * Generated Query Resolver for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RecurringQuery extends POQuery<MRecurring> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecurring.Table_Name;
	}

	public Connection<MRecurring> C_RecurringGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
