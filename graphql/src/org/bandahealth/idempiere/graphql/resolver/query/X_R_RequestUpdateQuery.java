package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestUpdate;

/**
 * Generated Query Resolver for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestUpdateQuery extends POQuery<MRequestUpdate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestUpdate.Table_Name;
	}

	public Connection<MRequestUpdate> R_RequestUpdateGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
