package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_CM_ChatTypeUpdate;

/**
 * Generated Query Resolver for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatTypeUpdateQuery extends POQuery<X_CM_ChatTypeUpdate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatTypeUpdate.Table_Name;
	}

	public Connection<X_CM_ChatTypeUpdate> CM_ChatTypeUpdateGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
