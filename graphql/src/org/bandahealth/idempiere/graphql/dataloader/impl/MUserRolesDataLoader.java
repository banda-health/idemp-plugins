package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MUserRoles;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.List;
import java.util.Properties;

public class MUserRolesDataLoader extends X_AD_User_RolesDataLoader {
	public static String DATALOADER_AD_User_Roles_BY_AD_User_ID = "AD_User_RolesByUserIdDataLoader";
	public static String DATALOADER_AD_User_Roles_BY_AD_Role_ID = "AD_User_RolesByRoleIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_User_Roles_BY_AD_User_ID,
				DataLoader.newMappedDataLoader(getByUserIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(DATALOADER_AD_User_Roles_BY_AD_Role_ID,
				DataLoader.newMappedDataLoader(getByRoleIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MUserRoles>> getByUserIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MUserRoles::getAD_User_ID,
				MUserRoles.COLUMNNAME_AD_User_ID, keys);
	}

	private MappedBatchLoaderWithContext<String, List<MUserRoles>> getByRoleIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> Repository.getGroupsByModelKeysCompletableFuture(
				batchLoaderEnvironment.getContext(), getTableName(), null, MUserRoles::getAD_Role_ID,
				MUserRoles.COLUMNNAME_AD_Role_ID, keys);
	}
}
