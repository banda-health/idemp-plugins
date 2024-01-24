package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AlertProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AlertProcessorInput;
import org.compiere.model.MAlertProcessor;

import java.util.List;

/**
 * Generated Query Resolver for AD_AlertProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AlertProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AlertProcessorInput.Table_Name;
	}

	public MAlertProcessor AD_AlertProcessorSave(I_AD_AlertProcessorInput input, DataFetchingEnvironment environment) {
		return (MAlertProcessor) super.save((X_AD_AlertProcessorInput) input, environment);
	}

	public boolean AD_AlertProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
