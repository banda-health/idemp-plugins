package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRfQResponse;

/**
 * Generated Query Resolver for C_RfQResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQResponseQuery extends POQuery<MRfQResponse> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRfQResponse.Table_Name;
	}

	public Connection<MRfQResponse> C_RfQResponseGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
