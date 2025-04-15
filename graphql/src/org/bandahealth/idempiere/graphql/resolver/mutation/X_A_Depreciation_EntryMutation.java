package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_EntryInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_EntryInput;
import org.compiere.model.MDepreciationEntry;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_EntryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_EntryInput.Table_Name;
	}

	public MDepreciationEntry A_Depreciation_EntrySave(I_A_Depreciation_EntryInput Entity, DataFetchingEnvironment environment) {
		return (MDepreciationEntry) super.save((X_A_Depreciation_EntryInput) Entity, environment);
	}

	public List<MDepreciationEntry> A_Depreciation_EntrySaveMany(List<I_A_Depreciation_EntryInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Depreciation_EntryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepreciationEntry) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_EntryDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
