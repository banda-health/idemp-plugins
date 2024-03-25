package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctProcessorLog;

/**
 * Generated Query Resolver for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctProcessorLogQuery extends POQuery<MAcctProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctProcessorLog.Table_Name;
	}

	public Connection<MAcctProcessorLog> C_AcctProcessorLogGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
