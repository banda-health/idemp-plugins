package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Replication_LogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Replication_LogInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Replication_LogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Replication_LogInput.Table_Name;
	}

	public MReplicationLog_BH AD_Replication_LogSave(I_AD_Replication_LogInput entity, DataFetchingEnvironment environment) {
		return (MReplicationLog_BH) super.save((X_AD_Replication_LogInput) entity, environment);
	}

	public List<MReplicationLog_BH> AD_Replication_LogSaveMany(List<I_AD_Replication_LogInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Replication_LogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReplicationLog_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_Replication_LogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
