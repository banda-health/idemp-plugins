package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_EXP_Processor_TypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_EXP_Processor_TypeInput;
import org.compiere.model.MEXPProcessorType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for EXP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_EXP_Processor_TypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_EXP_Processor_TypeInput.Table_Name;
	}

	public MEXPProcessorType EXP_Processor_TypeSave(I_EXP_Processor_TypeInput Entity, DataFetchingEnvironment environment) {
		return (MEXPProcessorType) super.save((X_EXP_Processor_TypeInput) Entity, environment);
	}

	public List<MEXPProcessorType> EXP_Processor_TypeSaveMany(List<I_EXP_Processor_TypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_EXP_Processor_TypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MEXPProcessorType) entity).collect(Collectors.toList());
	}

	public boolean EXP_Processor_TypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
