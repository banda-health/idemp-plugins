package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RegistrationInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_RegistrationInput;
import org.compiere.model.M_Registration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_RegistrationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_RegistrationInput.Table_Name;
	}

	public M_Registration AD_RegistrationSave(I_AD_RegistrationInput Entity, DataFetchingEnvironment environment) {
		return (M_Registration) super.save((X_AD_RegistrationInput) Entity, environment);
	}

	public List<M_Registration> AD_RegistrationSaveMany(List<I_AD_RegistrationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_RegistrationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (M_Registration) entity).collect(Collectors.toList());
	}

	public boolean AD_RegistrationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
