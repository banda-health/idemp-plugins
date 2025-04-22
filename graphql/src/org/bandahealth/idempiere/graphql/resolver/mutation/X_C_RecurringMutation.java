package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RecurringInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RecurringInput;
import org.compiere.model.MRecurring;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RecurringMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RecurringInput.Table_Name;
	}

	public MRecurring C_RecurringSave(I_C_RecurringInput Entity, DataFetchingEnvironment environment) {
		return (MRecurring) super.save((X_C_RecurringInput) Entity, environment);
	}

	public List<MRecurring> C_RecurringSaveMany(List<I_C_RecurringInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RecurringInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRecurring) entity).collect(Collectors.toList());
	}

	public boolean C_RecurringDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
