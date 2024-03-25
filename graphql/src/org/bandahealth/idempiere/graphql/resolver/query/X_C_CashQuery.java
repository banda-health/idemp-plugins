package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCash;

/**
 * Generated Query Resolver for C_Cash - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashQuery extends POQuery<MCash> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCash.Table_Name;
	}

	public Connection<MCash> C_CashGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
