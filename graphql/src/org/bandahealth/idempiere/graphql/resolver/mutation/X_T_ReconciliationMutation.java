package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_ReconciliationInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_ReconciliationInput;
import org.compiere.model.X_T_Reconciliation;

import java.util.List;

/**
 * Generated Query Resolver for T_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_ReconciliationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_ReconciliationInput.Table_Name;
	}

	public X_T_Reconciliation T_ReconciliationSave(I_T_ReconciliationInput input, DataFetchingEnvironment environment) {
		return (X_T_Reconciliation) super.save((X_T_ReconciliationInput) input, environment);
	}

	public boolean T_ReconciliationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
