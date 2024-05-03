package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_GL_Fund;

/**
 * Generated Query Resolver for GL_Fund - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_FundQuery extends POQuery<X_GL_Fund> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_GL_Fund.Table_Name;
	}

	public Connection<X_GL_Fund> GL_FundGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
