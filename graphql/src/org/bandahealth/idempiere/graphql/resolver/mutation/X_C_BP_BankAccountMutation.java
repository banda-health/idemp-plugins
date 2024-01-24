package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_BankAccountInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_BankAccountInput;
import org.compiere.model.MBPBankAccount;

import java.util.List;

/**
 * Generated Query Resolver for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BP_BankAccountMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_BankAccountInput.Table_Name;
	}

	public MBPBankAccount C_BP_BankAccountSave(I_C_BP_BankAccountInput input, DataFetchingEnvironment environment) {
		return (MBPBankAccount) super.save((X_C_BP_BankAccountInput) input, environment);
	}

	public boolean C_BP_BankAccountDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
