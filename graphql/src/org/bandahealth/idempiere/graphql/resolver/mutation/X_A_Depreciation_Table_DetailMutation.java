package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_Table_DetailInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_Table_DetailInput;
import org.compiere.model.X_A_Depreciation_Table_Detail;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_Table_DetailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_DetailInput.Table_Name;
	}

	public X_A_Depreciation_Table_Detail A_Depreciation_Table_DetailSave(I_A_Depreciation_Table_DetailInput Entity, DataFetchingEnvironment environment) {
		return (X_A_Depreciation_Table_Detail) super.save((X_A_Depreciation_Table_DetailInput) Entity, environment);
	}

	public List<X_A_Depreciation_Table_Detail> A_Depreciation_Table_DetailSaveMany(List<I_A_Depreciation_Table_DetailInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Depreciation_Table_DetailInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Depreciation_Table_Detail) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_Table_DetailDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
