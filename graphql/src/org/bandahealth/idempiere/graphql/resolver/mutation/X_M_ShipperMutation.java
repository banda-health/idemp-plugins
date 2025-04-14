package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperInput;
import org.compiere.model.MShipper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ShipperMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperInput.Table_Name;
	}

	public MShipper M_ShipperSave(I_M_ShipperInput Entity, DataFetchingEnvironment environment) {
		return (MShipper) super.save((X_M_ShipperInput) Entity, environment);
	}

	public List<MShipper> M_ShipperSaveMany(List<I_M_ShipperInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ShipperInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MShipper) entity).collect(Collectors.toList());
	}

	public boolean M_ShipperDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
