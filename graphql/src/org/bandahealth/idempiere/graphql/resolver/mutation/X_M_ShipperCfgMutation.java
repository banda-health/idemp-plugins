package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperCfgInput;
import org.compiere.model.X_M_ShipperCfg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShipperCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShipperCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperCfgInput.Table_Name;
	}

	public X_M_ShipperCfg M_ShipperCfgSave(I_M_ShipperCfgInput Entity, DataFetchingEnvironment environment) {
		return (X_M_ShipperCfg) super.save((X_M_ShipperCfgInput) Entity, environment);
	}

	public List<X_M_ShipperCfg> M_ShipperCfgSaveMany(List<I_M_ShipperCfgInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ShipperCfgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_ShipperCfg) entity).collect(Collectors.toList());
	}

	public boolean M_ShipperCfgDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
