package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_ProcessorParameterInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_ProcessorParameterInput;
import org.compiere.model.MEXPProcessorParameter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_EXP_ProcessorParameterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_ProcessorParameterInput.Table_Name;
	}

	public MEXPProcessorParameter EXP_ProcessorParameterSave(I_EXP_ProcessorParameterInput Entity, DataFetchingEnvironment environment) {
		return (MEXPProcessorParameter) super.save((X_EXP_ProcessorParameterInput) Entity, environment);
	}

	public List<MEXPProcessorParameter> EXP_ProcessorParameterSaveMany(List<I_EXP_ProcessorParameterInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_EXP_ProcessorParameterInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MEXPProcessorParameter) entity).collect(Collectors.toList());
	}

	public boolean EXP_ProcessorParameterDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
