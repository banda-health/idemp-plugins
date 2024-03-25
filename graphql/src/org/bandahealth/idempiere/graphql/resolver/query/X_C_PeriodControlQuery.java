package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPeriodControl;

/**
 * Generated Query Resolver for C_PeriodControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PeriodControlQuery extends POQuery<MPeriodControl> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPeriodControl.Table_Name;
	}

	public Connection<MPeriodControl> C_PeriodControlGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
