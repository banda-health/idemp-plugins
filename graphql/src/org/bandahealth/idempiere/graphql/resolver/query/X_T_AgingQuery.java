package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAging;

/**
 * Generated Query Resolver for T_Aging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_AgingQuery extends POQuery<MAging> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAging.Table_Name;
	}

	public Connection<MAging> T_AgingGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
