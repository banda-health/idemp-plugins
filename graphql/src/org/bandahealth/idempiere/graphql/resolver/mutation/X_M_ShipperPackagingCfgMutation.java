package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShipperPackagingCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShipperPackagingCfgInput;
import org.compiere.model.X_M_ShipperPackagingCfg;

import java.util.List;

/**
 * Generated Query Resolver for M_ShipperPackagingCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShipperPackagingCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperPackagingCfgInput.Table_Name;
	}

	public X_M_ShipperPackagingCfg M_ShipperPackagingCfgSave(I_M_ShipperPackagingCfgInput input, DataFetchingEnvironment environment) {
		return (X_M_ShipperPackagingCfg) super.save((X_M_ShipperPackagingCfgInput) input, environment);
	}

	public boolean M_ShipperPackagingCfgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
