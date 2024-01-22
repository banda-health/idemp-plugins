package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_Processor_TypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_Processor_TypeInput;
import org.compiere.model.MEXPProcessorType;

import java.util.List;

/**
 * Generated Query Resolver for EXP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_EXP_Processor_TypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_Processor_TypeInput.Table_Name;
	}

	public MEXPProcessorType EXP_Processor_TypeSave(I_EXP_Processor_TypeInput input, DataFetchingEnvironment environment) {
		return (MEXPProcessorType) super.save((X_EXP_Processor_TypeInput) input, environment);
	}

	public boolean EXP_Processor_TypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
