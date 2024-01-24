package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Ref_TableInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Ref_TableInput;
import org.compiere.model.MRefTable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Ref_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Ref_TableMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Ref_TableInput.Table_Name;
	}

	public MRefTable AD_Ref_TableSave(I_AD_Ref_TableInput entity, DataFetchingEnvironment environment) {
		return (MRefTable) super.save((X_AD_Ref_TableInput) entity, environment);
	}

	public List<MRefTable> AD_Ref_TableSaveMany(List<I_AD_Ref_TableInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Ref_TableInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRefTable) entity).collect(Collectors.toList());
	}

	public boolean AD_Ref_TableDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
