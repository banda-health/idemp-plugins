package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_EntryInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_EntryInput;
import org.compiere.model.MDepreciationEntry;

import java.util.List;

/**
 * Generated Query Resolver for A_Depreciation_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_EntryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_EntryInput.Table_Name;
	}

	public MDepreciationEntry A_Depreciation_EntrySave(I_A_Depreciation_EntryInput input, DataFetchingEnvironment environment) {
		return (MDepreciationEntry) super.save((X_A_Depreciation_EntryInput) input, environment);
	}

	public boolean A_Depreciation_EntryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
