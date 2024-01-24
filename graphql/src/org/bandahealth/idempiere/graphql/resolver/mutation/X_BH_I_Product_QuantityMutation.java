package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.X_BH_I_Product_Quantity;
import org.bandahealth.idempiere.graphql.model.input.I_BH_I_Product_QuantityInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_I_Product_QuantityInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_I_Product_Quantity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_I_Product_QuantityMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_I_Product_QuantityInput.Table_Name;
	}

	public X_BH_I_Product_Quantity BH_I_Product_QuantitySave(I_BH_I_Product_QuantityInput entity, DataFetchingEnvironment environment) {
		return (X_BH_I_Product_Quantity) super.save((X_BH_I_Product_QuantityInput) entity, environment);
	}

	public List<X_BH_I_Product_Quantity> BH_I_Product_QuantitySaveMany(List<I_BH_I_Product_QuantityInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_I_Product_QuantityInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_BH_I_Product_Quantity) entity).collect(Collectors.toList());
	}

	public boolean BH_I_Product_QuantityDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
