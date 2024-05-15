package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCurrencyAcct;

/**
 * Generated Query Resolver for C_Currency_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Currency_AcctQuery extends POQuery<MCurrencyAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCurrencyAcct.Table_Name;
	}

	public Connection<MCurrencyAcct> C_Currency_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
