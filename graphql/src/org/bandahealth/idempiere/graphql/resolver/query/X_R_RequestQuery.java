package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequest;

/**
 * Generated Query Resolver for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestQuery extends POQuery<MRequest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequest.Table_Name;
	}

	public Connection<MRequest> R_RequestGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
