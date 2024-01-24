package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_PaymentRef_BankAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_PaymentRef_BankAcctQuery extends POQuery<MBHPaymentRefBankAccount> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPaymentRefBankAccount.Table_Name;
	}

	public Connection<MBHPaymentRefBankAccount> BH_PaymentRef_BankAcctGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
