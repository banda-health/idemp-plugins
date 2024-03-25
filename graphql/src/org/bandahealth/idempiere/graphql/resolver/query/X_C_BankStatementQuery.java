package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankStatement;

/**
 * Generated Query Resolver for C_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankStatementQuery extends POQuery<MBankStatement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankStatement.Table_Name;
	}

	public Connection<MBankStatement> C_BankStatementGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
