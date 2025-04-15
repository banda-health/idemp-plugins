package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShippingProcessorCfgInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShippingProcessorCfgInput;
import org.compiere.model.X_M_ShippingProcessorCfg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShippingProcessorCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShippingProcessorCfgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShippingProcessorCfgInput.Table_Name;
	}

	public X_M_ShippingProcessorCfg M_ShippingProcessorCfgSave(I_M_ShippingProcessorCfgInput Entity, DataFetchingEnvironment environment) {
		return (X_M_ShippingProcessorCfg) super.save((X_M_ShippingProcessorCfgInput) Entity, environment);
	}

	public List<X_M_ShippingProcessorCfg> M_ShippingProcessorCfgSaveMany(List<I_M_ShippingProcessorCfgInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ShippingProcessorCfgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_ShippingProcessorCfg) entity).collect(Collectors.toList());
	}

	public boolean M_ShippingProcessorCfgDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
