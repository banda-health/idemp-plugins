package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_UserRemunerationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_UserRemunerationInput;
import org.compiere.model.X_C_UserRemuneration;

import java.util.List;

/**
 * Generated Query Resolver for C_UserRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_UserRemunerationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_UserRemunerationInput.Table_Name;
	}

	public X_C_UserRemuneration C_UserRemunerationSave(I_C_UserRemunerationInput input, DataFetchingEnvironment environment) {
		return (X_C_UserRemuneration) super.save((X_C_UserRemunerationInput) input, environment);
	}

	public boolean C_UserRemunerationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
