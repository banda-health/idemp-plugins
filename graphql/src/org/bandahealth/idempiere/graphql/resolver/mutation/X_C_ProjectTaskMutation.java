package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectTaskInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectTaskInput;
import org.compiere.model.MProjectTask;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectTaskMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectTaskInput.Table_Name;
	}

	public MProjectTask C_ProjectTaskSave(I_C_ProjectTaskInput Entity, DataFetchingEnvironment environment) {
		return (MProjectTask) super.save((X_C_ProjectTaskInput) Entity, environment);
	}

	public List<MProjectTask> C_ProjectTaskSaveMany(List<I_C_ProjectTaskInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ProjectTaskInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProjectTask) entity).collect(Collectors.toList());
	}

	public boolean C_ProjectTaskDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
