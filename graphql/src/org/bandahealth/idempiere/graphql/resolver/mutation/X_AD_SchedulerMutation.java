package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SchedulerInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SchedulerInput;
import org.compiere.model.MScheduler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Scheduler - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SchedulerMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SchedulerInput.Table_Name;
	}

	public MScheduler AD_SchedulerSave(I_AD_SchedulerInput Entity, DataFetchingEnvironment environment) {
		return (MScheduler) super.save((X_AD_SchedulerInput) Entity, environment);
	}

	public List<MScheduler> AD_SchedulerSaveMany(List<I_AD_SchedulerInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_SchedulerInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MScheduler) entity).collect(Collectors.toList());
	}

	public boolean AD_SchedulerDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
