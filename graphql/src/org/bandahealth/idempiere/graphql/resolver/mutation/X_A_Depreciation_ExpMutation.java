package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_ExpInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_ExpInput;
import org.compiere.model.MDepreciationExp;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_ExpMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_ExpInput.Table_Name;
	}

	public MDepreciationExp A_Depreciation_ExpSave(I_A_Depreciation_ExpInput entity, DataFetchingEnvironment environment) {
		return (MDepreciationExp) super.save((X_A_Depreciation_ExpInput) entity, environment);
	}

	public List<MDepreciationExp> A_Depreciation_ExpSaveMany(List<I_A_Depreciation_ExpInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Depreciation_ExpInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepreciationExp) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_ExpDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
