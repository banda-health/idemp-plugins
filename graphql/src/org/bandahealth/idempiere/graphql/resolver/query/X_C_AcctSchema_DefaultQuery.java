package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctSchemaDefault;

/**
 * Generated Query Resolver for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AcctSchema_DefaultQuery extends POQuery<MAcctSchemaDefault> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctSchemaDefault.Table_Name;
	}

	public Connection<MAcctSchemaDefault> C_AcctSchema_DefaultGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
