package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_CashFlowInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_CashFlowInput;
import org.compiere.model.X_T_CashFlow;

import java.util.List;

/**
 * Generated Query Resolver for T_CashFlow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_CashFlowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_CashFlowInput.Table_Name;
	}

	public X_T_CashFlow T_CashFlowSave(I_T_CashFlowInput input, DataFetchingEnvironment environment) {
		return (X_T_CashFlow) super.save((X_T_CashFlowInput) input, environment);
	}

	public boolean T_CashFlowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
