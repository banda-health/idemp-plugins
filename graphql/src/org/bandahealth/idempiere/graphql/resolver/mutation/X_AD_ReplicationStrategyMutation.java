package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReplicationStrategyInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReplicationStrategyInput;
import org.compiere.model.MReplicationStrategy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ReplicationStrategyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReplicationStrategyInput.Table_Name;
	}

	public MReplicationStrategy AD_ReplicationStrategySave(I_AD_ReplicationStrategyInput Entity, DataFetchingEnvironment environment) {
		return (MReplicationStrategy) super.save((X_AD_ReplicationStrategyInput) Entity, environment);
	}

	public List<MReplicationStrategy> AD_ReplicationStrategySaveMany(List<I_AD_ReplicationStrategyInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ReplicationStrategyInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReplicationStrategy) entity).collect(Collectors.toList());
	}

	public boolean AD_ReplicationStrategyDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
