package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_RegistrationInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_RegistrationInput;
import org.compiere.model.X_A_Registration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_RegistrationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationInput.Table_Name;
	}

	public X_A_Registration A_RegistrationSave(I_A_RegistrationInput Entity, DataFetchingEnvironment environment) {
		return (X_A_Registration) super.save((X_A_RegistrationInput) Entity, environment);
	}

	public List<X_A_Registration> A_RegistrationSaveMany(List<I_A_RegistrationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_RegistrationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Registration) entity).collect(Collectors.toList());
	}

	public boolean A_RegistrationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
