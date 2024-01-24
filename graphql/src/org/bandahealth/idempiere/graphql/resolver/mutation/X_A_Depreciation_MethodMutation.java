package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_MethodInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_MethodInput;
import org.compiere.model.MDepreciationMethod;

import java.util.List;

/**
 * Generated Query Resolver for A_Depreciation_Method - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Depreciation_MethodMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_MethodInput.Table_Name;
	}

	public MDepreciationMethod A_Depreciation_MethodSave(I_A_Depreciation_MethodInput input, DataFetchingEnvironment environment) {
		return (MDepreciationMethod) super.save((X_A_Depreciation_MethodInput) input, environment);
	}

	public boolean A_Depreciation_MethodDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
