package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_GL_FundRestriction;

/**
 * Generated Query Resolver for GL_FundRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_FundRestrictionQuery extends POQuery<X_GL_FundRestriction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_GL_FundRestriction.Table_Name;
	}

	public Connection<X_GL_FundRestriction> GL_FundRestrictionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
