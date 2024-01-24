package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RegistrationInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_RegistrationInput;
import org.compiere.model.M_Registration;

import java.util.List;

/**
 * Generated Query Resolver for AD_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RegistrationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_RegistrationInput.Table_Name;
	}

	public M_Registration AD_RegistrationSave(I_AD_RegistrationInput input, DataFetchingEnvironment environment) {
		return (M_Registration) super.save((X_AD_RegistrationInput) input, environment);
	}

	public boolean AD_RegistrationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
