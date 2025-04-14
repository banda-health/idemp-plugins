package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperPackagingInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperPackagingInput;
import org.compiere.model.MShipperPackaging;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ShipperPackagingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperPackagingInput.Table_Name;
	}

	public MShipperPackaging M_ShipperPackagingSave(I_M_ShipperPackagingInput Entity, DataFetchingEnvironment environment) {
		return (MShipperPackaging) super.save((X_M_ShipperPackagingInput) Entity, environment);
	}

	public List<MShipperPackaging> M_ShipperPackagingSaveMany(List<I_M_ShipperPackagingInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ShipperPackagingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MShipperPackaging) entity).collect(Collectors.toList());
	}

	public boolean M_ShipperPackagingDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
