package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_GroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_GroupInput;
import org.compiere.model.MGroup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_GroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_GroupInput.Table_Name;
	}

	public MGroup R_GroupSave(I_R_GroupInput entity, DataFetchingEnvironment environment) {
		return (MGroup) super.save((X_R_GroupInput) entity, environment);
	}

	public List<MGroup> R_GroupSaveMany(List<I_R_GroupInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_R_GroupInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MGroup) entity).collect(Collectors.toList());
	}

	public boolean R_GroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
