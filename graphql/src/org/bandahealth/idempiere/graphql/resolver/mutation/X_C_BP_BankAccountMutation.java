package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_BankAccountInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_BankAccountInput;
import org.compiere.model.MBPBankAccount;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BP_BankAccountMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_BankAccountInput.Table_Name;
	}

	public MBPBankAccount C_BP_BankAccountSave(I_C_BP_BankAccountInput Entity, DataFetchingEnvironment environment) {
		return (MBPBankAccount) super.save((X_C_BP_BankAccountInput) Entity, environment);
	}

	public List<MBPBankAccount> C_BP_BankAccountSaveMany(List<I_C_BP_BankAccountInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BP_BankAccountInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBPBankAccount) entity).collect(Collectors.toList());
	}

	public boolean C_BP_BankAccountDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
