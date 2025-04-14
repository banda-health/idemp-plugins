package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_BankAccountInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BankAccountInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BankAccountMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BankAccountInput.Table_Name;
	}

	public MBankAccount_BH C_BankAccountSave(I_C_BankAccountInput Entity, DataFetchingEnvironment environment) {
		return (MBankAccount_BH) super.save((X_C_BankAccountInput) Entity, environment);
	}

	public List<MBankAccount_BH> C_BankAccountSaveMany(List<I_C_BankAccountInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BankAccountInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBankAccount_BH) entity).collect(Collectors.toList());
	}

	public boolean C_BankAccountDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
