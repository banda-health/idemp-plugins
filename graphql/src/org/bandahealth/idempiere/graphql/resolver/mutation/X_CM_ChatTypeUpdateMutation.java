package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_CM_ChatTypeUpdateInput;
import org.bandahealth.idempiere.graphql.model.input.X_CM_ChatTypeUpdateInput;
import org.compiere.model.X_CM_ChatTypeUpdate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatTypeUpdateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatTypeUpdateInput.Table_Name;
	}

	public X_CM_ChatTypeUpdate CM_ChatTypeUpdateSave(I_CM_ChatTypeUpdateInput entity, DataFetchingEnvironment environment) {
		return (X_CM_ChatTypeUpdate) super.save((X_CM_ChatTypeUpdateInput) entity, environment);
	}

	public List<X_CM_ChatTypeUpdate> CM_ChatTypeUpdateSaveMany(List<I_CM_ChatTypeUpdateInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_CM_ChatTypeUpdateInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_CM_ChatTypeUpdate) entity).collect(Collectors.toList());
	}

	public boolean CM_ChatTypeUpdateDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
