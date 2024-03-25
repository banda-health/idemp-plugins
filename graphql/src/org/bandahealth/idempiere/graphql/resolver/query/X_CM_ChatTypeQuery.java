package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChatType;

/**
 * Generated Query Resolver for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_CM_ChatTypeQuery extends POQuery<MChatType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChatType.Table_Name;
	}

	public Connection<MChatType> CM_ChatTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
