package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_CM_ChatUpdateInput;
import org.bandahealth.idempiere.graphql.model.input.X_CM_ChatUpdateInput;
import org.compiere.model.X_CM_ChatUpdate;

import java.util.List;

/**
 * Generated Query Resolver for CM_ChatUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatUpdateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatUpdateInput.Table_Name;
	}

	public X_CM_ChatUpdate CM_ChatUpdateSave(I_CM_ChatUpdateInput input, DataFetchingEnvironment environment) {
		return (X_CM_ChatUpdate) super.save((X_CM_ChatUpdateInput) input, environment);
	}

	public boolean CM_ChatUpdateDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
