package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Recurring_RunInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Recurring_RunInput;
import org.compiere.model.MRecurringRun;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_Recurring_RunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Recurring_RunInput.Table_Name;
	}

	public MRecurringRun C_Recurring_RunSave(I_C_Recurring_RunInput Entity, DataFetchingEnvironment environment) {
		return (MRecurringRun) super.save((X_C_Recurring_RunInput) Entity, environment);
	}

	public List<MRecurringRun> C_Recurring_RunSaveMany(List<I_C_Recurring_RunInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_Recurring_RunInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRecurringRun) entity).collect(Collectors.toList());
	}

	public boolean C_Recurring_RunDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
