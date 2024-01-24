package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCalendar;

/**
 * Generated Query Resolver for C_Calendar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CalendarQuery extends POQuery<MCalendar> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCalendar.Table_Name;
	}

	public Connection<MCalendar> C_CalendarGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
