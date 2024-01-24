package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_InventoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_InventoryInput;
import org.compiere.model.X_I_Inventory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_InventoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_InventoryInput.Table_Name;
	}

	public X_I_Inventory I_InventorySave(I_I_InventoryInput entity, DataFetchingEnvironment environment) {
		return (X_I_Inventory) super.save((X_I_InventoryInput) entity, environment);
	}

	public List<X_I_Inventory> I_InventorySaveMany(List<I_I_InventoryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_InventoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_Inventory) entity).collect(Collectors.toList());
	}

	public boolean I_InventoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
