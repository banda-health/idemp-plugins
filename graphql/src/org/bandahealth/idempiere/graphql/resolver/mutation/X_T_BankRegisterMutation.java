package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_BankRegisterInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_BankRegisterInput;
import org.compiere.model.X_T_BankRegister;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_BankRegister - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_T_BankRegisterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_BankRegisterInput.Table_Name;
	}

	public X_T_BankRegister T_BankRegisterSave(I_T_BankRegisterInput Entity, DataFetchingEnvironment environment) {
		return (X_T_BankRegister) super.save((X_T_BankRegisterInput) Entity, environment);
	}

	public List<X_T_BankRegister> T_BankRegisterSaveMany(List<I_T_BankRegisterInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_T_BankRegisterInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_BankRegister) entity).collect(Collectors.toList());
	}

	public boolean T_BankRegisterDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
