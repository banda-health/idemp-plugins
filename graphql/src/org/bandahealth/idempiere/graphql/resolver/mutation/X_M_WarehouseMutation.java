package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_WarehouseInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_WarehouseInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_WarehouseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_WarehouseInput.Table_Name;
	}

	public MWarehouse_BH M_WarehouseSave(I_M_WarehouseInput entity, DataFetchingEnvironment environment) {
		return (MWarehouse_BH) super.save((X_M_WarehouseInput) entity, environment);
	}

	public List<MWarehouse_BH> M_WarehouseSaveMany(List<I_M_WarehouseInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_WarehouseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MWarehouse_BH) entity).collect(Collectors.toList());
	}

	public boolean M_WarehouseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
