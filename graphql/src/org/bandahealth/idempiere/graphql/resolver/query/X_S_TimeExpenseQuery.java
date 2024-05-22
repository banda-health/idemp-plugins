package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTimeExpense;

/**
 * Generated Query Resolver for S_TimeExpense - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_TimeExpenseQuery extends POQuery<MTimeExpense> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTimeExpense.Table_Name;
	}

	public Connection<MTimeExpense> S_TimeExpenseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
