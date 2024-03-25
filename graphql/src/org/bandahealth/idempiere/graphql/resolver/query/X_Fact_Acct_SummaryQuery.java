package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_Fact_Acct_Summary;

/**
 * Generated Query Resolver for Fact_Acct_Summary - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_Fact_Acct_SummaryQuery extends POQuery<X_Fact_Acct_Summary> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_Fact_Acct_Summary.Table_Name;
	}

	public Connection<X_Fact_Acct_Summary> Fact_Acct_SummaryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
