package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctSchema;

/**
 * Generated Query Resolver for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchemaQuery extends POQuery<MAcctSchema> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctSchema.Table_Name;
	}

	public Connection<MAcctSchema> C_AcctSchemaGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
