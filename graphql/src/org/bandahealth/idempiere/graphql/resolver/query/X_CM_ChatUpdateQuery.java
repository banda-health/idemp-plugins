package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_CM_ChatUpdate;

/**
 * Generated Query Resolver for CM_ChatUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatUpdateQuery extends POQuery<X_CM_ChatUpdate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatUpdate.Table_Name;
	}

	public Connection<X_CM_ChatUpdate> CM_ChatUpdateGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
