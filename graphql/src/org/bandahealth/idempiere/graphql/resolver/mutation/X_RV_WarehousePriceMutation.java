package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_RV_WarehousePriceInput;
import org.bandahealth.idempiere.graphql.model.input.X_RV_WarehousePriceInput;
import org.compiere.model.MWarehousePrice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for RV_WarehousePrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_RV_WarehousePriceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_RV_WarehousePriceInput.Table_Name;
	}

	public MWarehousePrice RV_WarehousePriceSave(I_RV_WarehousePriceInput entity, DataFetchingEnvironment environment) {
		return (MWarehousePrice) super.save((X_RV_WarehousePriceInput) entity, environment);
	}

	public List<MWarehousePrice> RV_WarehousePriceSaveMany(List<I_RV_WarehousePriceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_RV_WarehousePriceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MWarehousePrice) entity).collect(Collectors.toList());
	}

	public boolean RV_WarehousePriceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
