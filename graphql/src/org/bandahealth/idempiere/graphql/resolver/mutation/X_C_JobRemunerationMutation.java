package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_JobRemunerationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_JobRemunerationInput;
import org.compiere.model.X_C_JobRemuneration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_JobRemunerationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_JobRemunerationInput.Table_Name;
	}

	public X_C_JobRemuneration C_JobRemunerationSave(I_C_JobRemunerationInput Entity, DataFetchingEnvironment environment) {
		return (X_C_JobRemuneration) super.save((X_C_JobRemunerationInput) Entity, environment);
	}

	public List<X_C_JobRemuneration> C_JobRemunerationSaveMany(List<I_C_JobRemunerationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_JobRemunerationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_JobRemuneration) entity).collect(Collectors.toList());
	}

	public boolean C_JobRemunerationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
