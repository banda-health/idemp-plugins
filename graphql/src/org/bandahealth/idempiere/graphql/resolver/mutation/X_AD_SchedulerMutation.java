package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SchedulerInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SchedulerInput;
import org.compiere.model.MScheduler;

import java.util.List;

/**
 * Generated Query Resolver for AD_Scheduler - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_SchedulerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SchedulerInput.Table_Name;
	}

	public MScheduler AD_SchedulerSave(I_AD_SchedulerInput input, DataFetchingEnvironment environment) {
		return (MScheduler) super.save((X_AD_SchedulerInput) input, environment);
	}

	public boolean AD_SchedulerDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
