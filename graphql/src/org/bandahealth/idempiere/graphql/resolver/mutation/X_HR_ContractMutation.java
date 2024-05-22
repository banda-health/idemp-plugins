package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ContractInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ContractInput;
import org.eevolution.model.X_HR_Contract;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Contract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ContractMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ContractInput.Table_Name;
	}

	public X_HR_Contract HR_ContractSave(I_HR_ContractInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_Contract) super.save((X_HR_ContractInput) Entity, environment);
	}

	public List<X_HR_Contract> HR_ContractSaveMany(List<I_HR_ContractInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_ContractInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Contract) entity).collect(Collectors.toList());
	}

	public boolean HR_ContractDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
