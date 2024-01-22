package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrderPaySchedule;

/**
 * Generated Query Resolver for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderPayScheduleQuery extends POQuery<MOrderPaySchedule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrderPaySchedule.Table_Name;
	}

	public Connection<MOrderPaySchedule> C_OrderPayScheduleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
