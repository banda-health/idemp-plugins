package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_GL_Budget;

/**
 * Generated Query Resolver for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_BudgetQuery extends POQuery<X_GL_Budget> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_GL_Budget.Table_Name;
	}

	public Connection<X_GL_Budget> GL_BudgetGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
