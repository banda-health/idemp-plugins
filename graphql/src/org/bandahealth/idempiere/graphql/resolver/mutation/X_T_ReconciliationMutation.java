package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_ReconciliationInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_ReconciliationInput;
import org.compiere.model.X_T_Reconciliation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_ReconciliationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_ReconciliationInput.Table_Name;
	}

	public X_T_Reconciliation T_ReconciliationSave(I_T_ReconciliationInput Entity, DataFetchingEnvironment environment) {
		return (X_T_Reconciliation) super.save((X_T_ReconciliationInput) Entity, environment);
	}

	public List<X_T_Reconciliation> T_ReconciliationSaveMany(List<I_T_ReconciliationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_T_ReconciliationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_Reconciliation) entity).collect(Collectors.toList());
	}

	public boolean T_ReconciliationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
