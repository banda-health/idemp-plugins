package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SchedulerLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SchedulerLogInput;
import org.compiere.model.MSchedulerLog;

import java.util.List;

/**
 * Generated Query Resolver for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_SchedulerLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SchedulerLogInput.Table_Name;
	}

	public MSchedulerLog AD_SchedulerLogSave(I_AD_SchedulerLogInput input, DataFetchingEnvironment environment) {
		return (MSchedulerLog) super.save((X_AD_SchedulerLogInput) input, environment);
	}

	public boolean AD_SchedulerLogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
