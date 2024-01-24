package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_StorageReservationInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_StorageReservationInput;
import org.compiere.model.MStorageReservation;

import java.util.List;

/**
 * Generated Query Resolver for M_StorageReservation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_StorageReservationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_StorageReservationInput.Table_Name;
	}

	public MStorageReservation M_StorageReservationSave(I_M_StorageReservationInput input, DataFetchingEnvironment environment) {
		return (MStorageReservation) super.save((X_M_StorageReservationInput) input, environment);
	}

	public boolean M_StorageReservationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
