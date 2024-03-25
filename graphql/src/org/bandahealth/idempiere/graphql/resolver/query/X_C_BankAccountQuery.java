package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccountQuery extends POQuery<MBankAccount_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankAccount_BH.Table_Name;
	}

	public Connection<MBankAccount_BH> C_BankAccountGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
