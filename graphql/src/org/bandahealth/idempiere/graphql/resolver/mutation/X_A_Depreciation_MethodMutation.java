package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_MethodInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_MethodInput;
import org.compiere.model.MDepreciationMethod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Method - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_MethodMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_MethodInput.Table_Name;
	}

	public MDepreciationMethod A_Depreciation_MethodSave(I_A_Depreciation_MethodInput Entity, DataFetchingEnvironment environment) {
		return (MDepreciationMethod) super.save((X_A_Depreciation_MethodInput) Entity, environment);
	}

	public List<MDepreciationMethod> A_Depreciation_MethodSaveMany(List<I_A_Depreciation_MethodInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Depreciation_MethodInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepreciationMethod) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_MethodDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
