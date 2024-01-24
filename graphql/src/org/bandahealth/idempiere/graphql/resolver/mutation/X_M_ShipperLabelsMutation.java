package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperLabelsInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperLabelsInput;
import org.compiere.model.MShipperLabels;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShipperLabelsMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperLabelsInput.Table_Name;
	}

	public MShipperLabels M_ShipperLabelsSave(I_M_ShipperLabelsInput entity, DataFetchingEnvironment environment) {
		return (MShipperLabels) super.save((X_M_ShipperLabelsInput) entity, environment);
	}

	public List<MShipperLabels> M_ShipperLabelsSaveMany(List<I_M_ShipperLabelsInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_ShipperLabelsInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MShipperLabels) entity).collect(Collectors.toList());
	}

	public boolean M_ShipperLabelsDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
