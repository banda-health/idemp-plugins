package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChat;

/**
 * Generated Query Resolver for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_CM_ChatQuery extends POQuery<MChat> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChat.Table_Name;
	}

	public Connection<MChat> CM_ChatGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
