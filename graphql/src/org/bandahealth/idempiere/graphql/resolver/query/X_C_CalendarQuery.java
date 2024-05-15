package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCalendar;

/**
 * Generated Query Resolver for C_Calendar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CalendarQuery extends POQuery<MCalendar> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCalendar.Table_Name;
	}

	public Connection<MCalendar> C_CalendarGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
