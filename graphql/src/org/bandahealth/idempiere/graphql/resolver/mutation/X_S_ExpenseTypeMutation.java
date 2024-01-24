package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_ExpenseTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_ExpenseTypeInput;
import org.compiere.model.MExpenseType;

import java.util.List;

/**
 * Generated Query Resolver for S_ExpenseType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_S_ExpenseTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_ExpenseTypeInput.Table_Name;
	}

	public MExpenseType S_ExpenseTypeSave(I_S_ExpenseTypeInput input, DataFetchingEnvironment environment) {
		return (MExpenseType) super.save((X_S_ExpenseTypeInput) input, environment);
	}

	public boolean S_ExpenseTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
