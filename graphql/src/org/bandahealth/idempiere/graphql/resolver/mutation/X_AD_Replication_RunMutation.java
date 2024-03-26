package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Replication_RunInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Replication_RunInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Replication_RunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Replication_RunInput.Table_Name;
	}

	public MReplicationRun_BH AD_Replication_RunSave(I_AD_Replication_RunInput entity, DataFetchingEnvironment environment) {
		return (MReplicationRun_BH) super.save((X_AD_Replication_RunInput) entity, environment);
	}

	public List<MReplicationRun_BH> AD_Replication_RunSaveMany(List<I_AD_Replication_RunInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Replication_RunInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReplicationRun_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_Replication_RunDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
