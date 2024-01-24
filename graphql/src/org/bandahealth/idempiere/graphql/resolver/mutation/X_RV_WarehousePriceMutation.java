package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_RV_WarehousePriceInput;
import org.bandahealth.idempiere.graphql.model.input.X_RV_WarehousePriceInput;
import org.compiere.model.MWarehousePrice;

import java.util.List;

/**
 * Generated Query Resolver for RV_WarehousePrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_RV_WarehousePriceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_RV_WarehousePriceInput.Table_Name;
	}

	public MWarehousePrice RV_WarehousePriceSave(I_RV_WarehousePriceInput input, DataFetchingEnvironment environment) {
		return (MWarehousePrice) super.save((X_RV_WarehousePriceInput) input, environment);
	}

	public boolean RV_WarehousePriceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
