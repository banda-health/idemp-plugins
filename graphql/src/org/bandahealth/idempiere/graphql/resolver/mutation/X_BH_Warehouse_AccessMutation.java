package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHWarehouseAccess;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Warehouse_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Warehouse_AccessInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Warehouse_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Warehouse_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Warehouse_AccessInput.Table_Name;
	}

	public MBHWarehouseAccess BH_Warehouse_AccessSave(I_BH_Warehouse_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MBHWarehouseAccess) super.save((X_BH_Warehouse_AccessInput) Entity, environment);
	}

	public List<MBHWarehouseAccess> BH_Warehouse_AccessSaveMany(List<I_BH_Warehouse_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Warehouse_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHWarehouseAccess) entity).collect(Collectors.toList());
	}

	public boolean BH_Warehouse_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
