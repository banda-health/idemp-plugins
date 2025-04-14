package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SchedulerLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SchedulerLogInput;
import org.compiere.model.MSchedulerLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SchedulerLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SchedulerLogInput.Table_Name;
	}

	public MSchedulerLog AD_SchedulerLogSave(I_AD_SchedulerLogInput Entity, DataFetchingEnvironment environment) {
		return (MSchedulerLog) super.save((X_AD_SchedulerLogInput) Entity, environment);
	}

	public List<MSchedulerLog> AD_SchedulerLogSaveMany(List<I_AD_SchedulerLogInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_SchedulerLogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSchedulerLog) entity).collect(Collectors.toList());
	}

	public boolean AD_SchedulerLogDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
