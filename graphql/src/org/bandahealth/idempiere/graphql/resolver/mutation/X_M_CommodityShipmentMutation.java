package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CommodityShipmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CommodityShipmentInput;
import org.compiere.model.X_M_CommodityShipment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_CommodityShipment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_CommodityShipmentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CommodityShipmentInput.Table_Name;
	}

	public X_M_CommodityShipment M_CommodityShipmentSave(I_M_CommodityShipmentInput entity, DataFetchingEnvironment environment) {
		return (X_M_CommodityShipment) super.save((X_M_CommodityShipmentInput) entity, environment);
	}

	public List<X_M_CommodityShipment> M_CommodityShipmentSaveMany(List<I_M_CommodityShipmentInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_CommodityShipmentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_CommodityShipment) entity).collect(Collectors.toList());
	}

	public boolean M_CommodityShipmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
