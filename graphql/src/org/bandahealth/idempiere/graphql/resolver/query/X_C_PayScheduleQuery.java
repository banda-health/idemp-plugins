package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaySchedule;

/**
 * Generated Query Resolver for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PayScheduleQuery extends POQuery<MPaySchedule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaySchedule.Table_Name;
	}

	public Connection<MPaySchedule> C_PayScheduleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
