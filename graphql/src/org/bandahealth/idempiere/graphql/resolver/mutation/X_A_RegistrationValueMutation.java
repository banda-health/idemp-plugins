package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_RegistrationValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_RegistrationValueInput;
import org.compiere.model.X_A_RegistrationValue;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_RegistrationValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationValueInput.Table_Name;
	}

	public X_A_RegistrationValue A_RegistrationValueSave(I_A_RegistrationValueInput Entity, DataFetchingEnvironment environment) {
		return (X_A_RegistrationValue) super.save((X_A_RegistrationValueInput) Entity, environment);
	}

	public List<X_A_RegistrationValue> A_RegistrationValueSaveMany(List<I_A_RegistrationValueInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_RegistrationValueInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_RegistrationValue) entity).collect(Collectors.toList());
	}

	public boolean A_RegistrationValueDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
