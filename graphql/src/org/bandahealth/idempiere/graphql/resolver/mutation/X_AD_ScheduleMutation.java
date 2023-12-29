package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ScheduleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ScheduleInput;
import org.compiere.model.MSchedule;

import java.util.List;

/**
 * Generated Query Resolver for AD_Schedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ScheduleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ScheduleInput.Table_Name;
	}

	public MSchedule AD_ScheduleSave(I_AD_ScheduleInput input, DataFetchingEnvironment environment) {
		return (MSchedule) super.save((X_AD_ScheduleInput) input, environment);
	}

	public boolean AD_ScheduleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
