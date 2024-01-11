package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RecurringInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RecurringInput;
import org.compiere.model.MRecurring;

import java.util.List;

/**
 * Generated Query Resolver for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RecurringMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RecurringInput.Table_Name;
	}

	public MRecurring C_RecurringSave(I_C_RecurringInput input, DataFetchingEnvironment environment) {
		return (MRecurring) super.save((X_C_RecurringInput) input, environment);
	}

	public boolean C_RecurringDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
