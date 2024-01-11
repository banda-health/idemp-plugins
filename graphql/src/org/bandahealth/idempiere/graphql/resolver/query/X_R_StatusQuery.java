package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStatus;

/**
 * Generated Query Resolver for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_StatusQuery extends POQuery<MStatus> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStatus.Table_Name;
	}

	public Connection<MStatus> R_StatusGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
