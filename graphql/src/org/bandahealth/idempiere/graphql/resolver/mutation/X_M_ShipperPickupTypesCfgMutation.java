package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperPickupTypesCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperPickupTypesCfgInput;
import org.compiere.model.X_M_ShipperPickupTypesCfg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShipperPickupTypesCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShipperPickupTypesCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperPickupTypesCfgInput.Table_Name;
	}

	public X_M_ShipperPickupTypesCfg M_ShipperPickupTypesCfgSave(I_M_ShipperPickupTypesCfgInput Entity, DataFetchingEnvironment environment) {
		return (X_M_ShipperPickupTypesCfg) super.save((X_M_ShipperPickupTypesCfgInput) Entity, environment);
	}

	public List<X_M_ShipperPickupTypesCfg> M_ShipperPickupTypesCfgSaveMany(List<I_M_ShipperPickupTypesCfgInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ShipperPickupTypesCfgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_ShipperPickupTypesCfg) entity).collect(Collectors.toList());
	}

	public boolean M_ShipperPickupTypesCfgDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
