package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperLabelsCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperLabelsCfgInput;
import org.compiere.model.X_M_ShipperLabelsCfg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShipperLabelsCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperLabelsCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperLabelsCfgInput.Table_Name;
	}

	public X_M_ShipperLabelsCfg M_ShipperLabelsCfgSave(I_M_ShipperLabelsCfgInput entity, DataFetchingEnvironment environment) {
		return (X_M_ShipperLabelsCfg) super.save((X_M_ShipperLabelsCfgInput) entity, environment);
	}

	public List<X_M_ShipperLabelsCfg> M_ShipperLabelsCfgSaveMany(List<I_M_ShipperLabelsCfgInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_ShipperLabelsCfgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_ShipperLabelsCfg) entity).collect(Collectors.toList());
	}

	public boolean M_ShipperLabelsCfgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
