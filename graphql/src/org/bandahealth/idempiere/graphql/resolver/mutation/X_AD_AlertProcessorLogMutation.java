package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AlertProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AlertProcessorLogInput;
import org.compiere.model.MAlertProcessorLog;

import java.util.List;

/**
 * Generated Query Resolver for AD_AlertProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AlertProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AlertProcessorLogInput.Table_Name;
	}

	public MAlertProcessorLog AD_AlertProcessorLogSave(I_AD_AlertProcessorLogInput input, DataFetchingEnvironment environment) {
		return (MAlertProcessorLog) super.save((X_AD_AlertProcessorLogInput) input, environment);
	}

	public boolean AD_AlertProcessorLogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
