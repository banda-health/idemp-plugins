package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_FundingMode_Acct;

/**
 * Generated Query Resolver for A_FundingMode_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_FundingMode_AcctQuery extends POQuery<X_A_FundingMode_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_FundingMode_Acct.Table_Name;
	}

	public Connection<X_A_FundingMode_Acct> A_FundingMode_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
