package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_S_Training_Class;

/**
 * Generated Query Resolver for S_Training_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_Training_ClassQuery extends POQuery<X_S_Training_Class> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_S_Training_Class.Table_Name;
	}

	public Connection<X_S_Training_Class> S_Training_ClassGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
