package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_InventoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InventoryInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InventoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InventoryInput.Table_Name;
	}

	public MInventory_BH M_InventorySave(I_M_InventoryInput entity, DataFetchingEnvironment environment) {
		return (MInventory_BH) super.save((X_M_InventoryInput) entity, environment);
	}

	public List<MInventory_BH> M_InventorySaveMany(List<I_M_InventoryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_InventoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInventory_BH) entity).collect(Collectors.toList());
	}

	public boolean M_InventoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
