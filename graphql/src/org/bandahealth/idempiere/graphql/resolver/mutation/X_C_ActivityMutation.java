package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ActivityInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ActivityInput;
import org.compiere.model.MActivity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ActivityMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ActivityInput.Table_Name;
	}

	public MActivity C_ActivitySave(I_C_ActivityInput entity, DataFetchingEnvironment environment) {
		return (MActivity) super.save((X_C_ActivityInput) entity, environment);
	}

	public List<MActivity> C_ActivitySaveMany(List<I_C_ActivityInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_ActivityInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MActivity) entity).collect(Collectors.toList());
	}

	public boolean C_ActivityDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
