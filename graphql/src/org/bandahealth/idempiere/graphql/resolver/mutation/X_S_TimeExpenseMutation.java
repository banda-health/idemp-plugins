package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_TimeExpenseInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_TimeExpenseInput;
import org.compiere.model.MTimeExpense;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for S_TimeExpense - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_TimeExpenseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_TimeExpenseInput.Table_Name;
	}

	public MTimeExpense S_TimeExpenseSave(I_S_TimeExpenseInput Entity, DataFetchingEnvironment environment) {
		return (MTimeExpense) super.save((X_S_TimeExpenseInput) Entity, environment);
	}

	public List<MTimeExpense> S_TimeExpenseSaveMany(List<I_S_TimeExpenseInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_S_TimeExpenseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTimeExpense) entity).collect(Collectors.toList());
	}

	public boolean S_TimeExpenseDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
