package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_ElementValue;

/**
 * Generated Query Resolver for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ElementValueQuery extends POQuery<X_I_ElementValue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_ElementValue.Table_Name;
	}

	public Connection<X_I_ElementValue> I_ElementValueGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
