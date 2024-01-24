package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.graphql.model.input.I_BH_PaymentRef_BankAcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_PaymentRef_BankAcctInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_PaymentRef_BankAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_PaymentRef_BankAcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_PaymentRef_BankAcctInput.Table_Name;
	}

	public MBHPaymentRefBankAccount BH_PaymentRef_BankAcctSave(I_BH_PaymentRef_BankAcctInput entity, DataFetchingEnvironment environment) {
		return (MBHPaymentRefBankAccount) super.save((X_BH_PaymentRef_BankAcctInput) entity, environment);
	}

	public List<MBHPaymentRefBankAccount> BH_PaymentRef_BankAcctSaveMany(List<I_BH_PaymentRef_BankAcctInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_PaymentRef_BankAcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPaymentRefBankAccount) entity).collect(Collectors.toList());
	}

	public boolean BH_PaymentRef_BankAcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
