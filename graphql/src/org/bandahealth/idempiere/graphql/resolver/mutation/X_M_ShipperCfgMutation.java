package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperCfgInput;
import org.compiere.model.X_M_ShipperCfg;

import java.util.List;

/**
 * Generated Query Resolver for M_ShipperCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperCfgInput.Table_Name;
	}

	public X_M_ShipperCfg M_ShipperCfgSave(I_M_ShipperCfgInput input, DataFetchingEnvironment environment) {
		return (X_M_ShipperCfg) super.save((X_M_ShipperCfgInput) input, environment);
	}

	public boolean M_ShipperCfgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
