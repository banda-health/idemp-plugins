package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OnlineTrxHistoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OnlineTrxHistoryInput;
import org.compiere.model.MOnlineTrxHistory;

import java.util.List;

/**
 * Generated Query Resolver for C_OnlineTrxHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OnlineTrxHistoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OnlineTrxHistoryInput.Table_Name;
	}

	public MOnlineTrxHistory C_OnlineTrxHistorySave(I_C_OnlineTrxHistoryInput input, DataFetchingEnvironment environment) {
		return (MOnlineTrxHistory) super.save((X_C_OnlineTrxHistoryInput) input, environment);
	}

	public boolean C_OnlineTrxHistoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
