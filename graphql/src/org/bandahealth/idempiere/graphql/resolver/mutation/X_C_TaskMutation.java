package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaskInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaskInput;
import org.compiere.model.MProjectTypeTask;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaskMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaskInput.Table_Name;
	}

	public MProjectTypeTask C_TaskSave(I_C_TaskInput Entity, DataFetchingEnvironment environment) {
		return (MProjectTypeTask) super.save((X_C_TaskInput) Entity, environment);
	}

	public List<MProjectTypeTask> C_TaskSaveMany(List<I_C_TaskInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_TaskInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProjectTypeTask) entity).collect(Collectors.toList());
	}

	public boolean C_TaskDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
