package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AlertProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AlertProcessorInput;
import org.compiere.model.MAlertProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AlertProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AlertProcessorInput.Table_Name;
	}

	public MAlertProcessor AD_AlertProcessorSave(I_AD_AlertProcessorInput Entity, DataFetchingEnvironment environment) {
		return (MAlertProcessor) super.save((X_AD_AlertProcessorInput) Entity, environment);
	}

	public List<MAlertProcessor> AD_AlertProcessorSaveMany(List<I_AD_AlertProcessorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_AlertProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAlertProcessor) entity).collect(Collectors.toList());
	}

	public boolean AD_AlertProcessorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
