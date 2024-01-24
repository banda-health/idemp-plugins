package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_RegistrationInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_RegistrationInput;
import org.compiere.model.MRegistration;

import java.util.List;
import java.util.stream.Collectors;

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

	public MRegistration A_RegistrationSave(I_A_RegistrationInput entity, DataFetchingEnvironment environment) {
		return (MRegistration) super.save((X_A_RegistrationInput) entity, environment);
	}

	public List<MRegistration> A_RegistrationSaveMany(List<I_A_RegistrationInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_RegistrationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRegistration) entity).collect(Collectors.toList());
	}

	public boolean A_RegistrationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
