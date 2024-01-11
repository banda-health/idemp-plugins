package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ContractInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ContractInput;
import org.eevolution.model.X_HR_Contract;

import java.util.List;

/**
 * Generated Query Resolver for HR_Contract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ContractMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ContractInput.Table_Name;
	}

	public X_HR_Contract HR_ContractSave(I_HR_ContractInput input, DataFetchingEnvironment environment) {
		return (X_HR_Contract) super.save((X_HR_ContractInput) input, environment);
	}

	public boolean HR_ContractDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
