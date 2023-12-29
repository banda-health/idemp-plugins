package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperPackagingInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperPackagingInput;
import org.compiere.model.MShipperPackaging;

import java.util.List;

/**
 * Generated Query Resolver for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperPackagingInput.Table_Name;
	}

	public MShipperPackaging M_ShipperPackagingSave(I_M_ShipperPackagingInput input, DataFetchingEnvironment environment) {
		return (MShipperPackaging) super.save((X_M_ShipperPackagingInput) input, environment);
	}

	public boolean M_ShipperPackagingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
