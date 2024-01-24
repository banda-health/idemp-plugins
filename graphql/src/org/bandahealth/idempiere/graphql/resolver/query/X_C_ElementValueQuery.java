package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MElementValue;

/**
 * Generated Query Resolver for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ElementValueQuery extends POQuery<MElementValue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MElementValue.Table_Name;
	}

	public Connection<MElementValue> C_ElementValueGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
