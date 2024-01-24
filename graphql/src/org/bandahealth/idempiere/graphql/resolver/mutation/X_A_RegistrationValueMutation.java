package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_RegistrationValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_RegistrationValueInput;
import org.compiere.model.MRegistrationValue;

import java.util.List;

/**
 * Generated Query Resolver for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationValueInput.Table_Name;
	}

	public MRegistrationValue A_RegistrationValueSave(I_A_RegistrationValueInput input, DataFetchingEnvironment environment) {
		return (MRegistrationValue) super.save((X_A_RegistrationValueInput) input, environment);
	}

	public boolean A_RegistrationValueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
