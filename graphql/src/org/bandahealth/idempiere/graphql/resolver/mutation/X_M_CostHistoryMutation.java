package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CostHistoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CostHistoryInput;
import org.compiere.model.X_M_CostHistory;

import java.util.List;

/**
 * Generated Query Resolver for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostHistoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CostHistoryInput.Table_Name;
	}

	public X_M_CostHistory M_CostHistorySave(I_M_CostHistoryInput input, DataFetchingEnvironment environment) {
		return (X_M_CostHistory) super.save((X_M_CostHistoryInput) input, environment);
	}

	public boolean M_CostHistoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
