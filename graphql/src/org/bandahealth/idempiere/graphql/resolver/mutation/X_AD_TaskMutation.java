package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TaskInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TaskInput;
import org.compiere.model.MTask;

import java.util.List;

/**
 * Generated Query Resolver for AD_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TaskMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TaskInput.Table_Name;
	}

	public MTask AD_TaskSave(I_AD_TaskInput input, DataFetchingEnvironment environment) {
		return (MTask) super.save((X_AD_TaskInput) input, environment);
	}

	public boolean AD_TaskDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
