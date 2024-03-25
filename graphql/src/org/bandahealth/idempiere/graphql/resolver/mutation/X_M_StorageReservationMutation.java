package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_StorageReservationInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_StorageReservationInput;
import org.compiere.model.MStorageReservation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_StorageReservation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_StorageReservationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_StorageReservationInput.Table_Name;
	}

	public MStorageReservation M_StorageReservationSave(I_M_StorageReservationInput entity, DataFetchingEnvironment environment) {
		return (MStorageReservation) super.save((X_M_StorageReservationInput) entity, environment);
	}

	public List<MStorageReservation> M_StorageReservationSaveMany(List<I_M_StorageReservationInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_StorageReservationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MStorageReservation) entity).collect(Collectors.toList());
	}

	public boolean M_StorageReservationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
