package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Replication_RunInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Replication_RunInput;
import org.compiere.model.MReplicationRun;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Replication_RunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Replication_RunInput.Table_Name;
	}

	public MReplicationRun AD_Replication_RunSave(I_AD_Replication_RunInput Entity, DataFetchingEnvironment environment) {
		return (MReplicationRun) super.save((X_AD_Replication_RunInput) Entity, environment);
	}

	public List<MReplicationRun> AD_Replication_RunSaveMany(List<I_AD_Replication_RunInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Replication_RunInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReplicationRun) entity).collect(Collectors.toList());
	}

	public boolean AD_Replication_RunDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
