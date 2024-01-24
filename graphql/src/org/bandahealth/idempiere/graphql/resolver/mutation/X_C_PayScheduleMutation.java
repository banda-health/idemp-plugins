package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PayScheduleInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PayScheduleInput;
import org.compiere.model.MPaySchedule;

import java.util.List;

/**
 * Generated Query Resolver for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PayScheduleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PayScheduleInput.Table_Name;
	}

	public MPaySchedule C_PayScheduleSave(I_C_PayScheduleInput input, DataFetchingEnvironment environment) {
		return (MPaySchedule) super.save((X_C_PayScheduleInput) input, environment);
	}

	public boolean C_PayScheduleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
