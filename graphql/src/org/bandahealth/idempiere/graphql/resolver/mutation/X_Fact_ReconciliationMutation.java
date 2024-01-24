package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_Fact_ReconciliationInput;
import org.bandahealth.idempiere.graphql.model.input.X_Fact_ReconciliationInput;
import org.compiere.model.MFactReconciliation;

import java.util.List;

/**
 * Generated Query Resolver for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_Fact_ReconciliationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_Fact_ReconciliationInput.Table_Name;
	}

	public MFactReconciliation Fact_ReconciliationSave(I_Fact_ReconciliationInput input, DataFetchingEnvironment environment) {
		return (MFactReconciliation) super.save((X_Fact_ReconciliationInput) input, environment);
	}

	public boolean Fact_ReconciliationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
