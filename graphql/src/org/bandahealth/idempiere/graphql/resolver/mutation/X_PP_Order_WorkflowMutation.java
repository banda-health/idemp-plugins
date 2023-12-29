package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_WorkflowInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_WorkflowInput;
import org.eevolution.model.X_PP_Order_Workflow;

import java.util.List;

/**
 * Generated Query Resolver for PP_Order_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_WorkflowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_WorkflowInput.Table_Name;
	}

	public X_PP_Order_Workflow PP_Order_WorkflowSave(I_PP_Order_WorkflowInput input, DataFetchingEnvironment environment) {
		return (X_PP_Order_Workflow) super.save((X_PP_Order_WorkflowInput) input, environment);
	}

	public boolean PP_Order_WorkflowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
