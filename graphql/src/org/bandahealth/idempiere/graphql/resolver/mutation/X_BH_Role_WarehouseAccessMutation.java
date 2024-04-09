package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Role_WarehouseAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Role_WarehouseAccessInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Role_WarehouseAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Role_WarehouseAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Role_WarehouseAccessInput.Table_Name;
	}

	public MBHRoleWarehouseAccess BH_Role_WarehouseAccessSave(I_BH_Role_WarehouseAccessInput Entity, DataFetchingEnvironment environment) {
		return (MBHRoleWarehouseAccess) super.save((X_BH_Role_WarehouseAccessInput) Entity, environment);
	}

	public List<MBHRoleWarehouseAccess> BH_Role_WarehouseAccessSaveMany(List<I_BH_Role_WarehouseAccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Role_WarehouseAccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHRoleWarehouseAccess) entity).collect(Collectors.toList());
	}

	public boolean BH_Role_WarehouseAccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
