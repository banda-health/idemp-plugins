package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_DepreciationInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_DepreciationInput;
import org.compiere.model.MDepreciation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_DepreciationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_DepreciationInput.Table_Name;
	}

	public MDepreciation A_DepreciationSave(I_A_DepreciationInput Entity, DataFetchingEnvironment environment) {
		return (MDepreciation) super.save((X_A_DepreciationInput) Entity, environment);
	}

	public List<MDepreciation> A_DepreciationSaveMany(List<I_A_DepreciationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_DepreciationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepreciation) entity).collect(Collectors.toList());
	}

	public boolean A_DepreciationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
