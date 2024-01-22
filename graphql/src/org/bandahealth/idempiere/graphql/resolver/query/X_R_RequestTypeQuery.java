package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestType;

/**
 * Generated Query Resolver for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestTypeQuery extends POQuery<MRequestType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestType.Table_Name;
	}

	public Connection<MRequestType> R_RequestTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
