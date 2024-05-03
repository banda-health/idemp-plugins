package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_Fact_ReconciliationInput;
import org.bandahealth.idempiere.graphql.model.input.X_Fact_ReconciliationInput;
import org.compiere.model.MFactReconciliation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for Fact_Reconciliation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_Fact_ReconciliationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_Fact_ReconciliationInput.Table_Name;
	}

	public MFactReconciliation Fact_ReconciliationSave(I_Fact_ReconciliationInput Entity, DataFetchingEnvironment environment) {
		return (MFactReconciliation) super.save((X_Fact_ReconciliationInput) Entity, environment);
	}

	public List<MFactReconciliation> Fact_ReconciliationSaveMany(List<I_Fact_ReconciliationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_Fact_ReconciliationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MFactReconciliation) entity).collect(Collectors.toList());
	}

	public boolean Fact_ReconciliationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
