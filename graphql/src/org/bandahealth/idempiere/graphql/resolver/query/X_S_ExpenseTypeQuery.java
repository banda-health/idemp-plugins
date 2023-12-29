package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MExpenseType;

/**
 * Generated Query Resolver for S_ExpenseType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ExpenseTypeQuery extends POQuery<MExpenseType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MExpenseType.Table_Name;
	}

	public Connection<MExpenseType> S_ExpenseTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
