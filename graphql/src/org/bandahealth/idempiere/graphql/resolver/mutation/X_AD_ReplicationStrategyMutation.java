package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReplicationStrategyInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReplicationStrategyInput;
import org.compiere.model.MReplicationStrategy;

import java.util.List;

/**
 * Generated Query Resolver for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReplicationStrategyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReplicationStrategyInput.Table_Name;
	}

	public MReplicationStrategy AD_ReplicationStrategySave(I_AD_ReplicationStrategyInput input, DataFetchingEnvironment environment) {
		return (MReplicationStrategy) super.save((X_AD_ReplicationStrategyInput) input, environment);
	}

	public boolean AD_ReplicationStrategyDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
