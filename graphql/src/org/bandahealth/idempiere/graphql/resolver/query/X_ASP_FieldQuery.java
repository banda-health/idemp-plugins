package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Field;

/**
 * Generated Query Resolver for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_FieldQuery extends POQuery<X_ASP_Field> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Field.Table_Name;
	}

	public Connection<X_ASP_Field> ASP_FieldGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
