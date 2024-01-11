package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLdapProcessor;

/**
 * Generated Query Resolver for AD_LdapProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapProcessorQuery extends POQuery<MLdapProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLdapProcessor.Table_Name;
	}

	public Connection<MLdapProcessor> AD_LdapProcessorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
