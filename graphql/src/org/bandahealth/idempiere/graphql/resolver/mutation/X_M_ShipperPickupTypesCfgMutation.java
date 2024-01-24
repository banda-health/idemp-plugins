package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperPickupTypesCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperPickupTypesCfgInput;
import org.compiere.model.X_M_ShipperPickupTypesCfg;

import java.util.List;

/**
 * Generated Query Resolver for M_ShipperPickupTypesCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPickupTypesCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperPickupTypesCfgInput.Table_Name;
	}

	public X_M_ShipperPickupTypesCfg M_ShipperPickupTypesCfgSave(I_M_ShipperPickupTypesCfgInput input, DataFetchingEnvironment environment) {
		return (X_M_ShipperPickupTypesCfg) super.save((X_M_ShipperPickupTypesCfgInput) input, environment);
	}

	public boolean M_ShipperPickupTypesCfgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
