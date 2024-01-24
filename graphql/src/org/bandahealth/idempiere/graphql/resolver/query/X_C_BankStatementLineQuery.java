package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankStatementLine;

/**
 * Generated Query Resolver for C_BankStatementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankStatementLineQuery extends POQuery<MBankStatementLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankStatementLine.Table_Name;
	}

	public Connection<MBankStatementLine> C_BankStatementLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
