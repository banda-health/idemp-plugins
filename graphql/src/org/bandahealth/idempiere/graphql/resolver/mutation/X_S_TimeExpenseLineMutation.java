package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_TimeExpenseLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_TimeExpenseLineInput;
import org.compiere.model.MTimeExpenseLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for S_TimeExpenseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_TimeExpenseLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_TimeExpenseLineInput.Table_Name;
	}

	public MTimeExpenseLine S_TimeExpenseLineSave(I_S_TimeExpenseLineInput entity, DataFetchingEnvironment environment) {
		return (MTimeExpenseLine) super.save((X_S_TimeExpenseLineInput) entity, environment);
	}

	public List<MTimeExpenseLine> S_TimeExpenseLineSaveMany(List<I_S_TimeExpenseLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_S_TimeExpenseLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTimeExpenseLine) entity).collect(Collectors.toList());
	}

	public boolean S_TimeExpenseLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
