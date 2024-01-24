package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Role_WarehouseAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Role_WarehouseAccessInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Role_WarehouseAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Role_WarehouseAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Role_WarehouseAccessInput.Table_Name;
	}

	public MBHRoleWarehouseAccess BH_Role_WarehouseAccessSave(I_BH_Role_WarehouseAccessInput input, DataFetchingEnvironment environment) {
		return (MBHRoleWarehouseAccess) super.save((X_BH_Role_WarehouseAccessInput) input, environment);
	}

	public boolean BH_Role_WarehouseAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
