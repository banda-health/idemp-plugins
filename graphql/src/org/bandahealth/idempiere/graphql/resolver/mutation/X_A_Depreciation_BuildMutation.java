package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_BuildInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_BuildInput;
import org.compiere.model.MDepreciationBuild;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Build - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_BuildMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_BuildInput.Table_Name;
	}

	public MDepreciationBuild A_Depreciation_BuildSave(I_A_Depreciation_BuildInput Entity, DataFetchingEnvironment environment) {
		return (MDepreciationBuild) super.save((X_A_Depreciation_BuildInput) Entity, environment);
	}

	public List<MDepreciationBuild> A_Depreciation_BuildSaveMany(List<I_A_Depreciation_BuildInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Depreciation_BuildInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepreciationBuild) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_BuildDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
