package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_InventoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InventoryInput;

import java.util.List;

/**
 * Generated Query Resolver for M_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_InventoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InventoryInput.Table_Name;
	}

	public MInventory_BH M_InventorySave(I_M_InventoryInput input, DataFetchingEnvironment environment) {
		return (MInventory_BH) super.save((X_M_InventoryInput) input, environment);
	}

	public boolean M_InventoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
