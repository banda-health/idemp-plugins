package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLdapProcessorLog;

/**
 * Generated Query Resolver for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapProcessorLogQuery extends POQuery<MLdapProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLdapProcessorLog.Table_Name;
	}

	public Connection<MLdapProcessorLog> AD_LdapProcessorLogGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
