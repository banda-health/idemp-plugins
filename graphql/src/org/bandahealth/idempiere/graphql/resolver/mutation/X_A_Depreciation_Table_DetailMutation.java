package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_Table_DetailInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_Table_DetailInput;
import org.compiere.model.X_A_Depreciation_Table_Detail;

import java.util.List;

/**
 * Generated Query Resolver for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Depreciation_Table_DetailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_DetailInput.Table_Name;
	}

	public X_A_Depreciation_Table_Detail A_Depreciation_Table_DetailSave(I_A_Depreciation_Table_DetailInput input, DataFetchingEnvironment environment) {
		return (X_A_Depreciation_Table_Detail) super.save((X_A_Depreciation_Table_DetailInput) input, environment);
	}

	public boolean A_Depreciation_Table_DetailDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
