package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_JobRemunerationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_JobRemunerationInput;
import org.compiere.model.X_C_JobRemuneration;

import java.util.List;

/**
 * Generated Query Resolver for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_JobRemunerationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_JobRemunerationInput.Table_Name;
	}

	public X_C_JobRemuneration C_JobRemunerationSave(I_C_JobRemunerationInput input, DataFetchingEnvironment environment) {
		return (X_C_JobRemuneration) super.save((X_C_JobRemunerationInput) input, environment);
	}

	public boolean C_JobRemunerationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
