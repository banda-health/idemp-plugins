package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperPickupTypesInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperPickupTypesInput;
import org.compiere.model.MShipperPickupTypes;

import java.util.List;

/**
 * Generated Query Resolver for M_ShipperPickupTypes - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPickupTypesMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperPickupTypesInput.Table_Name;
	}

	public MShipperPickupTypes M_ShipperPickupTypesSave(I_M_ShipperPickupTypesInput input, DataFetchingEnvironment environment) {
		return (MShipperPickupTypes) super.save((X_M_ShipperPickupTypesInput) input, environment);
	}

	public boolean M_ShipperPickupTypesDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
