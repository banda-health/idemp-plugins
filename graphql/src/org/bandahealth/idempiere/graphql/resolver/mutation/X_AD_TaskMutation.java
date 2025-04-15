package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TaskInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TaskInput;
import org.compiere.model.MTask;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TaskMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TaskInput.Table_Name;
	}

	public MTask AD_TaskSave(I_AD_TaskInput Entity, DataFetchingEnvironment environment) {
		return (MTask) super.save((X_AD_TaskInput) Entity, environment);
	}

	public List<MTask> AD_TaskSaveMany(List<I_AD_TaskInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TaskInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTask) entity).collect(Collectors.toList());
	}

	public boolean AD_TaskDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
