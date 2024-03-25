package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RemunerationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RemunerationInput;
import org.compiere.model.X_C_Remuneration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Remuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RemunerationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RemunerationInput.Table_Name;
	}

	public X_C_Remuneration C_RemunerationSave(I_C_RemunerationInput entity, DataFetchingEnvironment environment) {
		return (X_C_Remuneration) super.save((X_C_RemunerationInput) entity, environment);
	}

	public List<X_C_Remuneration> C_RemunerationSaveMany(List<I_C_RemunerationInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_RemunerationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Remuneration) entity).collect(Collectors.toList());
	}

	public boolean C_RemunerationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
