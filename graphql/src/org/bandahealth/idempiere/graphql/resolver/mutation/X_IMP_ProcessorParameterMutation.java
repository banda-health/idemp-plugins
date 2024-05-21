package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_IMP_ProcessorParameterInput;
import org.bandahealth.idempiere.graphql.model.input.X_IMP_ProcessorParameterInput;
import org.compiere.model.X_IMP_ProcessorParameter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_ProcessorParameterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_IMP_ProcessorParameterInput.Table_Name;
	}

	public X_IMP_ProcessorParameter IMP_ProcessorParameterSave(I_IMP_ProcessorParameterInput Entity, DataFetchingEnvironment environment) {
		return (X_IMP_ProcessorParameter) super.save((X_IMP_ProcessorParameterInput) Entity, environment);
	}

	public List<X_IMP_ProcessorParameter> IMP_ProcessorParameterSaveMany(List<I_IMP_ProcessorParameterInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_IMP_ProcessorParameterInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_IMP_ProcessorParameter) entity).collect(Collectors.toList());
	}

	public boolean IMP_ProcessorParameterDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
