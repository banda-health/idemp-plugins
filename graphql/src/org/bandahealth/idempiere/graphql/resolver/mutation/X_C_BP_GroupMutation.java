package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_GroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_GroupInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_GroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_GroupInput.Table_Name;
	}

	public MBPGroup_BH C_BP_GroupSave(I_C_BP_GroupInput entity, DataFetchingEnvironment environment) {
		return (MBPGroup_BH) super.save((X_C_BP_GroupInput) entity, environment);
	}

	public List<MBPGroup_BH> C_BP_GroupSaveMany(List<I_C_BP_GroupInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_BP_GroupInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBPGroup_BH) entity).collect(Collectors.toList());
	}

	public boolean C_BP_GroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
