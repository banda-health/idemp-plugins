package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_BankStatement;

/**
 * Generated Query Resolver for I_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_BankStatementQuery extends POQuery<X_I_BankStatement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_BankStatement.Table_Name;
	}

	public Connection<X_I_BankStatement> I_BankStatementGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
