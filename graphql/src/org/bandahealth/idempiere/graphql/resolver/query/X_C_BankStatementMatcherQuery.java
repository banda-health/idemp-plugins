package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankStatementMatcher;

/**
 * Generated Query Resolver for C_BankStatementMatcher - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankStatementMatcherQuery extends POQuery<MBankStatementMatcher> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankStatementMatcher.Table_Name;
	}

	public Connection<MBankStatementMatcher> C_BankStatementMatcherGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
