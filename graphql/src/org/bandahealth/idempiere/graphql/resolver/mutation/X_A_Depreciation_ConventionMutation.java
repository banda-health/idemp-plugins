package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_ConventionInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_ConventionInput;
import org.compiere.model.MDepreciationConvention;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Convention - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_ConventionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_ConventionInput.Table_Name;
	}

	public MDepreciationConvention A_Depreciation_ConventionSave(I_A_Depreciation_ConventionInput entity, DataFetchingEnvironment environment) {
		return (MDepreciationConvention) super.save((X_A_Depreciation_ConventionInput) entity, environment);
	}

	public List<MDepreciationConvention> A_Depreciation_ConventionSaveMany(List<I_A_Depreciation_ConventionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Depreciation_ConventionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepreciationConvention) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_ConventionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
