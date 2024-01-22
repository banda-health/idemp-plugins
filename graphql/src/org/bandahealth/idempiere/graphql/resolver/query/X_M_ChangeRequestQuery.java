package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChangeRequest;

/**
 * Generated Query Resolver for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ChangeRequestQuery extends POQuery<MChangeRequest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChangeRequest.Table_Name;
	}

	public Connection<MChangeRequest> M_ChangeRequestGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
