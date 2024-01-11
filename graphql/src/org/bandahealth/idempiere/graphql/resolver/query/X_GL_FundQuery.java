package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_GL_Fund;

/**
 * Generated Query Resolver for GL_Fund - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_FundQuery extends POQuery<X_GL_Fund> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_GL_Fund.Table_Name;
	}

	public Connection<X_GL_Fund> GL_FundGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
