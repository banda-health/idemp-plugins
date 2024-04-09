package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WorkflowInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WorkflowInput;
import org.compiere.model.X_AD_Workflow;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WorkflowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WorkflowInput.Table_Name;
	}

	public X_AD_Workflow AD_WorkflowSave(I_AD_WorkflowInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_Workflow) super.save((X_AD_WorkflowInput) Entity, environment);
	}

	public List<X_AD_Workflow> AD_WorkflowSaveMany(List<I_AD_WorkflowInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WorkflowInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Workflow) entity).collect(Collectors.toList());
	}

	public boolean AD_WorkflowDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
