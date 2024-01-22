package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_TimeExpenseInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_TimeExpenseInput;
import org.compiere.model.MTimeExpense;

import java.util.List;

/**
 * Generated Query Resolver for S_TimeExpense - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_TimeExpenseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_TimeExpenseInput.Table_Name;
	}

	public MTimeExpense S_TimeExpenseSave(I_S_TimeExpenseInput input, DataFetchingEnvironment environment) {
		return (MTimeExpense) super.save((X_S_TimeExpenseInput) input, environment);
	}

	public boolean S_TimeExpenseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
