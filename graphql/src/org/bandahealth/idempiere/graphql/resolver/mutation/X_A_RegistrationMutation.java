package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_RegistrationInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_RegistrationInput;
import org.compiere.model.MRegistration;

import java.util.List;

/**
 * Generated Query Resolver for A_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationInput.Table_Name;
	}

	public MRegistration A_RegistrationSave(I_A_RegistrationInput input, DataFetchingEnvironment environment) {
		return (MRegistration) super.save((X_A_RegistrationInput) input, environment);
	}

	public boolean A_RegistrationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
