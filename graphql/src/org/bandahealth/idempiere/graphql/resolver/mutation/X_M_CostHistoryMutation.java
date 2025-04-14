package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CostHistoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CostHistoryInput;
import org.compiere.model.MCostHistory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_CostHistoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CostHistoryInput.Table_Name;
	}

	public MCostHistory M_CostHistorySave(I_M_CostHistoryInput Entity, DataFetchingEnvironment environment) {
		return (MCostHistory) super.save((X_M_CostHistoryInput) Entity, environment);
	}

	public List<MCostHistory> M_CostHistorySaveMany(List<I_M_CostHistoryInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_CostHistoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCostHistory) entity).collect(Collectors.toList());
	}

	public boolean M_CostHistoryDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
