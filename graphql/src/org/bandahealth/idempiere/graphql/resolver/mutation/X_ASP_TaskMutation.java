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
 * @version Release 12 - $Id$
 */
public class X_ASP_TaskMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_TaskInput.Table_Name;
	}

	public X_ASP_Task ASP_TaskSave(I_ASP_TaskInput Entity, DataFetchingEnvironment environment) {
		return (X_ASP_Task) super.save((X_ASP_TaskInput) Entity, environment);
	}

	public List<X_ASP_Task> ASP_TaskSaveMany(List<I_ASP_TaskInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_ASP_TaskInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Task) entity).collect(Collectors.toList());
	}

	public boolean ASP_TaskDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
