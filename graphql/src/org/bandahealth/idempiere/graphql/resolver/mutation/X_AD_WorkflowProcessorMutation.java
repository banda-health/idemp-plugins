package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WorkflowProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WorkflowProcessorInput;
import org.compiere.model.X_AD_WorkflowProcessor;

import java.util.List;

/**
 * Generated Query Resolver for AD_WorkflowProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WorkflowProcessorInput.Table_Name;
	}

	public X_AD_WorkflowProcessor AD_WorkflowProcessorSave(I_AD_WorkflowProcessorInput input, DataFetchingEnvironment environment) {
		return (X_AD_WorkflowProcessor) super.save((X_AD_WorkflowProcessorInput) input, environment);
	}

	public boolean AD_WorkflowProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
