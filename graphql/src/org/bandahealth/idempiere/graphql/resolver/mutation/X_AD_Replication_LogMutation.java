package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Replication_LogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Replication_LogInput;
import org.compiere.model.MReplicationLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Replication_LogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Replication_LogInput.Table_Name;
	}

	public MReplicationLog AD_Replication_LogSave(I_AD_Replication_LogInput Entity, DataFetchingEnvironment environment) {
		return (MReplicationLog) super.save((X_AD_Replication_LogInput) Entity, environment);
	}

	public List<MReplicationLog> AD_Replication_LogSaveMany(List<I_AD_Replication_LogInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Replication_LogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReplicationLog) entity).collect(Collectors.toList());
	}

	public boolean AD_Replication_LogDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
