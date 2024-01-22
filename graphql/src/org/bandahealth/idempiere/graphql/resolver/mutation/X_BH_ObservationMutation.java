package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.graphql.model.input.I_BH_ObservationInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_ObservationInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Observation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_ObservationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_ObservationInput.Table_Name;
	}

	public MBHObservation BH_ObservationSave(I_BH_ObservationInput input, DataFetchingEnvironment environment) {
		return (MBHObservation) super.save((X_BH_ObservationInput) input, environment);
	}

	public boolean BH_ObservationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
