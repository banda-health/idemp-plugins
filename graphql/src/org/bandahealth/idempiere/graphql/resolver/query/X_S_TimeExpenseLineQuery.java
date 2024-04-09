package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTimeExpenseLine;

/**
 * Generated Query Resolver for S_TimeExpenseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_TimeExpenseLineQuery extends POQuery<MTimeExpenseLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTimeExpenseLine.Table_Name;
	}

	public Connection<MTimeExpenseLine> S_TimeExpenseLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
