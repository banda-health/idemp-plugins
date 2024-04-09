package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AlertProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AlertProcessorLogInput;
import org.compiere.model.MAlertProcessorLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AlertProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AlertProcessorLogInput.Table_Name;
	}

	public MAlertProcessorLog AD_AlertProcessorLogSave(I_AD_AlertProcessorLogInput Entity, DataFetchingEnvironment environment) {
		return (MAlertProcessorLog) super.save((X_AD_AlertProcessorLogInput) Entity, environment);
	}

	public List<MAlertProcessorLog> AD_AlertProcessorLogSaveMany(List<I_AD_AlertProcessorLogInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_AlertProcessorLogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAlertProcessorLog) entity).collect(Collectors.toList());
	}

	public boolean AD_AlertProcessorLogDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
