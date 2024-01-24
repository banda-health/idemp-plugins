package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_ProcessorParameterInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_ProcessorParameterInput;
import org.compiere.model.MEXPProcessorParameter;

import java.util.List;

/**
 * Generated Query Resolver for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_EXP_ProcessorParameterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_ProcessorParameterInput.Table_Name;
	}

	public MEXPProcessorParameter EXP_ProcessorParameterSave(I_EXP_ProcessorParameterInput input, DataFetchingEnvironment environment) {
		return (MEXPProcessorParameter) super.save((X_EXP_ProcessorParameterInput) input, environment);
	}

	public boolean EXP_ProcessorParameterDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
