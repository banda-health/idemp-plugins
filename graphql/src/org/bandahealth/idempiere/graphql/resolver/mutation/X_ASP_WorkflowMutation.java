package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_WorkflowInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_WorkflowInput;
import org.compiere.model.X_ASP_Workflow;

import java.util.List;

/**
 * Generated Query Resolver for ASP_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_WorkflowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_WorkflowInput.Table_Name;
	}

	public X_ASP_Workflow ASP_WorkflowSave(I_ASP_WorkflowInput input, DataFetchingEnvironment environment) {
		return (X_ASP_Workflow) super.save((X_ASP_WorkflowInput) input, environment);
	}

	public boolean ASP_WorkflowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
