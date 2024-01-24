package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_ExpenseTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_ExpenseTypeInput;
import org.compiere.model.MExpenseType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for S_ExpenseType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_S_ExpenseTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_ExpenseTypeInput.Table_Name;
	}

	public MExpenseType S_ExpenseTypeSave(I_S_ExpenseTypeInput entity, DataFetchingEnvironment environment) {
		return (MExpenseType) super.save((X_S_ExpenseTypeInput) entity, environment);
	}

	public List<MExpenseType> S_ExpenseTypeSaveMany(List<I_S_ExpenseTypeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_S_ExpenseTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MExpenseType) entity).collect(Collectors.toList());
	}

	public boolean S_ExpenseTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
