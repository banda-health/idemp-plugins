package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectInput;
import org.compiere.model.MProject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Project - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectInput.Table_Name;
	}

	public MProject C_ProjectSave(I_C_ProjectInput Entity, DataFetchingEnvironment environment) {
		return (MProject) super.save((X_C_ProjectInput) Entity, environment);
	}

	public List<MProject> C_ProjectSaveMany(List<I_C_ProjectInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ProjectInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProject) entity).collect(Collectors.toList());
	}

	public boolean C_ProjectDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
