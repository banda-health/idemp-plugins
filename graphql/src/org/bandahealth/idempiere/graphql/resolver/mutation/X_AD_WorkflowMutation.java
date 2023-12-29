package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WorkflowInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WorkflowInput;
import org.compiere.model.X_AD_Workflow;

import java.util.List;

/**
 * Generated Query Resolver for AD_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WorkflowInput.Table_Name;
	}

	public X_AD_Workflow AD_WorkflowSave(I_AD_WorkflowInput input, DataFetchingEnvironment environment) {
		return (X_AD_Workflow) super.save((X_AD_WorkflowInput) input, environment);
	}

	public boolean AD_WorkflowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
