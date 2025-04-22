package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.graphql.model.input.I_BH_ObservationInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_ObservationInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Observation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_ObservationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_ObservationInput.Table_Name;
	}

	public MBHObservation BH_ObservationSave(I_BH_ObservationInput Entity, DataFetchingEnvironment environment) {
		return (MBHObservation) super.save((X_BH_ObservationInput) Entity, environment);
	}

	public List<MBHObservation> BH_ObservationSaveMany(List<I_BH_ObservationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_ObservationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHObservation) entity).collect(Collectors.toList());
	}

	public boolean BH_ObservationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
