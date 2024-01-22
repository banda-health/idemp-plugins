package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectTaskInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectTaskInput;
import org.compiere.model.MProjectTask;

import java.util.List;

/**
 * Generated Query Resolver for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectTaskMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectTaskInput.Table_Name;
	}

	public MProjectTask C_ProjectTaskSave(I_C_ProjectTaskInput input, DataFetchingEnvironment environment) {
		return (MProjectTask) super.save((X_C_ProjectTaskInput) input, environment);
	}

	public boolean C_ProjectTaskDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
