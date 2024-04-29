package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperPickupTypesInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperPickupTypesInput;
import org.compiere.model.MShipperPickupTypes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperPickupTypesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperPickupTypesInput.Table_Name;
	}

	public MShipperPickupTypes M_ShipperPickupTypesSave(I_M_ShipperPickupTypesInput Entity, DataFetchingEnvironment environment) {
		return (MShipperPickupTypes) super.save((X_M_ShipperPickupTypesInput) Entity, environment);
	}

	public List<MShipperPickupTypes> M_ShipperPickupTypesSaveMany(List<I_M_ShipperPickupTypesInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ShipperPickupTypesInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MShipperPickupTypes) entity).collect(Collectors.toList());
	}

	public boolean M_ShipperPickupTypesDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
