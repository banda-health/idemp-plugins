package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_BroadcastMessageInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_BroadcastMessageInput;
import org.compiere.model.X_AD_BroadcastMessage;

import java.util.List;

/**
 * Generated Query Resolver for AD_BroadcastMessage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_BroadcastMessageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_BroadcastMessageInput.Table_Name;
	}

	public X_AD_BroadcastMessage AD_BroadcastMessageSave(I_AD_BroadcastMessageInput input, DataFetchingEnvironment environment) {
		return (X_AD_BroadcastMessage) super.save((X_AD_BroadcastMessageInput) input, environment);
	}

	public boolean AD_BroadcastMessageDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
