package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_1099Box;

/**
 * Generated Query Resolver for C_1099Box - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_1099BoxQuery extends POQuery<X_C_1099Box> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_1099Box.Table_Name;
	}

	public Connection<X_C_1099Box> C_1099BoxGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
