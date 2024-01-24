package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Scheduler_ParaInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Scheduler_ParaInput;
import org.compiere.model.MSchedulerPara;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Scheduler_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Scheduler_ParaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Scheduler_ParaInput.Table_Name;
	}

	public MSchedulerPara AD_Scheduler_ParaSave(I_AD_Scheduler_ParaInput entity, DataFetchingEnvironment environment) {
		return (MSchedulerPara) super.save((X_AD_Scheduler_ParaInput) entity, environment);
	}

	public List<MSchedulerPara> AD_Scheduler_ParaSaveMany(List<I_AD_Scheduler_ParaInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Scheduler_ParaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSchedulerPara) entity).collect(Collectors.toList());
	}

	public boolean AD_Scheduler_ParaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
