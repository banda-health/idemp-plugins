package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_ProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_ProcessorInput;
import org.compiere.model.MEXPProcessor;

import java.util.List;

/**
 * Generated Query Resolver for EXP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_EXP_ProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_ProcessorInput.Table_Name;
	}

	public MEXPProcessor EXP_ProcessorSave(I_EXP_ProcessorInput input, DataFetchingEnvironment environment) {
		return (MEXPProcessor) super.save((X_EXP_ProcessorInput) input, environment);
	}

	public boolean EXP_ProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
