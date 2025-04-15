package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_CashFlowInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_CashFlowInput;
import org.compiere.model.X_T_CashFlow;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_CashFlow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_CashFlowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_CashFlowInput.Table_Name;
	}

	public X_T_CashFlow T_CashFlowSave(I_T_CashFlowInput Entity, DataFetchingEnvironment environment) {
		return (X_T_CashFlow) super.save((X_T_CashFlowInput) Entity, environment);
	}

	public List<X_T_CashFlow> T_CashFlowSaveMany(List<I_T_CashFlowInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_T_CashFlowInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_CashFlow) entity).collect(Collectors.toList());
	}

	public boolean T_CashFlowDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
