package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WorkflowProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WorkflowProcessorLogInput;
import org.compiere.model.X_AD_WorkflowProcessorLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WorkflowProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WorkflowProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WorkflowProcessorLogInput.Table_Name;
	}

	public X_AD_WorkflowProcessorLog AD_WorkflowProcessorLogSave(I_AD_WorkflowProcessorLogInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_WorkflowProcessorLog) super.save((X_AD_WorkflowProcessorLogInput) Entity, environment);
	}

	public List<X_AD_WorkflowProcessorLog> AD_WorkflowProcessorLogSaveMany(List<I_AD_WorkflowProcessorLogInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WorkflowProcessorLogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WorkflowProcessorLog) entity).collect(Collectors.toList());
	}

	public boolean AD_WorkflowProcessorLogDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
