package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReplicationInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReplicationInput;
import org.compiere.model.MReplication;

import java.util.List;

/**
 * Generated Query Resolver for AD_Replication - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReplicationInput.Table_Name;
	}

	public MReplication AD_ReplicationSave(I_AD_ReplicationInput input, DataFetchingEnvironment environment) {
		return (MReplication) super.save((X_AD_ReplicationInput) input, environment);
	}

	public boolean AD_ReplicationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
