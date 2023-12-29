package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShippingProcessorCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShippingProcessorCfgInput;
import org.compiere.model.X_M_ShippingProcessorCfg;

import java.util.List;

/**
 * Generated Query Resolver for M_ShippingProcessorCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingProcessorCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShippingProcessorCfgInput.Table_Name;
	}

	public X_M_ShippingProcessorCfg M_ShippingProcessorCfgSave(I_M_ShippingProcessorCfgInput input, DataFetchingEnvironment environment) {
		return (X_M_ShippingProcessorCfg) super.save((X_M_ShippingProcessorCfgInput) input, environment);
	}

	public boolean M_ShippingProcessorCfgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
