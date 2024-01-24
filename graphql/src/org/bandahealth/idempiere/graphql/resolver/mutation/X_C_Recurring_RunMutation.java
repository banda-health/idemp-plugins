package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Recurring_RunInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Recurring_RunInput;
import org.compiere.model.MRecurringRun;

import java.util.List;

/**
 * Generated Query Resolver for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Recurring_RunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Recurring_RunInput.Table_Name;
	}

	public MRecurringRun C_Recurring_RunSave(I_C_Recurring_RunInput input, DataFetchingEnvironment environment) {
		return (MRecurringRun) super.save((X_C_Recurring_RunInput) input, environment);
	}

	public boolean C_Recurring_RunDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
