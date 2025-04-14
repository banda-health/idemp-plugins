package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_CM_ChatUpdateInput;
import org.bandahealth.idempiere.graphql.model.input.X_CM_ChatUpdateInput;
import org.compiere.model.X_CM_ChatUpdate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for CM_ChatUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_CM_ChatUpdateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatUpdateInput.Table_Name;
	}

	public X_CM_ChatUpdate CM_ChatUpdateSave(I_CM_ChatUpdateInput Entity, DataFetchingEnvironment environment) {
		return (X_CM_ChatUpdate) super.save((X_CM_ChatUpdateInput) Entity, environment);
	}

	public List<X_CM_ChatUpdate> CM_ChatUpdateSaveMany(List<I_CM_ChatUpdateInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_CM_ChatUpdateInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_CM_ChatUpdate) entity).collect(Collectors.toList());
	}

	public boolean CM_ChatUpdateDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
