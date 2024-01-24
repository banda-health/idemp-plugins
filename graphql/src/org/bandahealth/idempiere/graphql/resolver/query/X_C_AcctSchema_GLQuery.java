package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctSchemaGL;

/**
 * Generated Query Resolver for C_AcctSchema_GL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AcctSchema_GLQuery extends POQuery<MAcctSchemaGL> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctSchemaGL.Table_Name;
	}

	public Connection<MAcctSchemaGL> C_AcctSchema_GLGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
