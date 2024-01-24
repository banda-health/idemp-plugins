package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_ExpInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_ExpInput;
import org.compiere.model.MDepreciationExp;

import java.util.List;

/**
 * Generated Query Resolver for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_ExpMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_ExpInput.Table_Name;
	}

	public MDepreciationExp A_Depreciation_ExpSave(I_A_Depreciation_ExpInput input, DataFetchingEnvironment environment) {
		return (MDepreciationExp) super.save((X_A_Depreciation_ExpInput) input, environment);
	}

	public boolean A_Depreciation_ExpDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
