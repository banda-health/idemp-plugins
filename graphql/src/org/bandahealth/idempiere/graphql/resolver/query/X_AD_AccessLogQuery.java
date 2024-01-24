package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAccessLog;

/**
 * Generated Query Resolver for AD_AccessLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AccessLogQuery extends POQuery<MAccessLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAccessLog.Table_Name;
	}

	public Connection<MAccessLog> AD_AccessLogGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
