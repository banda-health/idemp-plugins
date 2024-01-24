package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_RegistrationValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_RegistrationValueInput;
import org.compiere.model.MRegistrationValue;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_RegistrationValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationValueInput.Table_Name;
	}

	public MRegistrationValue A_RegistrationValueSave(I_A_RegistrationValueInput entity, DataFetchingEnvironment environment) {
		return (MRegistrationValue) super.save((X_A_RegistrationValueInput) entity, environment);
	}

	public List<MRegistrationValue> A_RegistrationValueSaveMany(List<I_A_RegistrationValueInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_RegistrationValueInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRegistrationValue) entity).collect(Collectors.toList());
	}

	public boolean A_RegistrationValueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
