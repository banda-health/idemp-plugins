package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_WorkfileInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_WorkfileInput;
import org.compiere.model.MDepreciationWorkfile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_WorkfileMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_WorkfileInput.Table_Name;
	}

	public MDepreciationWorkfile A_Depreciation_WorkfileSave(I_A_Depreciation_WorkfileInput entity, DataFetchingEnvironment environment) {
		return (MDepreciationWorkfile) super.save((X_A_Depreciation_WorkfileInput) entity, environment);
	}

	public List<MDepreciationWorkfile> A_Depreciation_WorkfileSaveMany(List<I_A_Depreciation_WorkfileInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Depreciation_WorkfileInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDepreciationWorkfile) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_WorkfileDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
