package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_Order_WorkflowInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_Order_WorkflowInput;
import org.eevolution.model.X_PP_Order_Workflow;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PP_Order_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Order_WorkflowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_WorkflowInput.Table_Name;
	}

	public X_PP_Order_Workflow PP_Order_WorkflowSave(I_PP_Order_WorkflowInput Entity, DataFetchingEnvironment environment) {
		return (X_PP_Order_Workflow) super.save((X_PP_Order_WorkflowInput) Entity, environment);
	}

	public List<X_PP_Order_Workflow> PP_Order_WorkflowSaveMany(List<I_PP_Order_WorkflowInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PP_Order_WorkflowInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PP_Order_Workflow) entity).collect(Collectors.toList());
	}

	public boolean PP_Order_WorkflowDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
