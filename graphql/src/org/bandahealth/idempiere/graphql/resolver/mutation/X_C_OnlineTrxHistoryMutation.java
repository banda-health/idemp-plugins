package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OnlineTrxHistoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OnlineTrxHistoryInput;
import org.compiere.model.MOnlineTrxHistory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_OnlineTrxHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OnlineTrxHistoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OnlineTrxHistoryInput.Table_Name;
	}

	public MOnlineTrxHistory C_OnlineTrxHistorySave(I_C_OnlineTrxHistoryInput entity, DataFetchingEnvironment environment) {
		return (MOnlineTrxHistory) super.save((X_C_OnlineTrxHistoryInput) entity, environment);
	}

	public List<MOnlineTrxHistory> C_OnlineTrxHistorySaveMany(List<I_C_OnlineTrxHistoryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_OnlineTrxHistoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOnlineTrxHistory) entity).collect(Collectors.toList());
	}

	public boolean C_OnlineTrxHistoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
