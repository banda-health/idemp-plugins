package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_TaskInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_TaskInput;
import org.compiere.model.X_ASP_Task;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_TaskMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_TaskInput.Table_Name;
	}

	public X_ASP_Task ASP_TaskSave(I_ASP_TaskInput entity, DataFetchingEnvironment environment) {
		return (X_ASP_Task) super.save((X_ASP_TaskInput) entity, environment);
	}

	public List<X_ASP_Task> ASP_TaskSaveMany(List<I_ASP_TaskInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_ASP_TaskInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Task) entity).collect(Collectors.toList());
	}

	public boolean ASP_TaskDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
