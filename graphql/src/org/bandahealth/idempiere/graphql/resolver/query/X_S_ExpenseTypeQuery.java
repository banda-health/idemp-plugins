package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MExpenseType;

/**
 * Generated Query Resolver for S_ExpenseType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_ExpenseTypeQuery extends POQuery<MExpenseType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MExpenseType.Table_Name;
	}

	public Connection<MExpenseType> S_ExpenseTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
