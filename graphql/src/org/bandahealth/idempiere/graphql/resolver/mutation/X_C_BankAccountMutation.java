package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankAccountInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankAccountInput;

import java.util.List;

/**
 * Generated Query Resolver for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccountMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankAccountInput.Table_Name;
	}

	public MBankAccount_BH C_BankAccountSave(I_C_BankAccountInput input, DataFetchingEnvironment environment) {
		return (MBankAccount_BH) super.save((X_C_BankAccountInput) input, environment);
	}

	public boolean C_BankAccountDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
