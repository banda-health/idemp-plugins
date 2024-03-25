package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WorkflowProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WorkflowProcessorInput;
import org.compiere.model.X_AD_WorkflowProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WorkflowProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WorkflowProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WorkflowProcessorInput.Table_Name;
	}

	public X_AD_WorkflowProcessor AD_WorkflowProcessorSave(I_AD_WorkflowProcessorInput entity, DataFetchingEnvironment environment) {
		return (X_AD_WorkflowProcessor) super.save((X_AD_WorkflowProcessorInput) entity, environment);
	}

	public List<X_AD_WorkflowProcessor> AD_WorkflowProcessorSaveMany(List<I_AD_WorkflowProcessorInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_WorkflowProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WorkflowProcessor) entity).collect(Collectors.toList());
	}

	public boolean AD_WorkflowProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
