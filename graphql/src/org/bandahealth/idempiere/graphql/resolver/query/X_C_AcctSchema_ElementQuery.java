package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctSchemaElement;

/**
 * Generated Query Resolver for C_AcctSchema_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchema_ElementQuery extends POQuery<MAcctSchemaElement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctSchemaElement.Table_Name;
	}

	public Connection<MAcctSchemaElement> C_AcctSchema_ElementGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
