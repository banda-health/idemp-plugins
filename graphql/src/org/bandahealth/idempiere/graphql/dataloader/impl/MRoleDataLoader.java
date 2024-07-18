package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MUserRoles;
import org.compiere.model.PO;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MRoleDataLoader extends X_AD_RoleDataLoader {
	public static String DATALOADER_AD_Role_BY_AD_Organization_ID = "AD_RoleByOrganizationIdDataLoader";
	public static String DATALOADER_AD_Role_BY_AD_User_ID = "AD_RoleByUserIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(DATALOADER_AD_Role_BY_AD_Organization_ID,
				DataLoader.newMappedDataLoader(getByOrganizationIdBatchLoader(), getOptionsWithCache(idempiereContext)));
		registry.register(DATALOADER_AD_Role_BY_AD_User_ID,
				DataLoader.newMappedDataLoader(getByUserIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<X_AD_Role>> getByOrganizationIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			try {
				Set<Integer> organizationIds = keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet());

				// If the user is currently the system client, we can get everything
				if (Env.getAD_Client_ID(batchLoaderEnvironment.getContext()) == 0) {
					Repository.setApplyAccessFilterNotNeeded();
					PO.setCrossTenantSafe();
				}
				Map<Integer, Integer> clientIdsByOrganizationId =
						Repository.<MOrg>getByIds(batchLoaderEnvironment.getContext(), MOrg.Table_Name, null, organizationIds)
								.values().stream().collect(Collectors.toMap(PO::getAD_Org_ID, PO::getAD_Client_ID));

				// The following methods modify the context, so make a copy and set it
				Properties contextCopy = new Properties();
				contextCopy.putAll(batchLoaderEnvironment.getContext());
				ServerContext.setCurrentInstance(contextCopy);
				Env.setCtx(contextCopy);
				MUser_BH currentUser = new MUser_BH(contextCopy, Env.getAD_User_ID(contextCopy), null);

				Map<String, List<X_AD_Role>> rolesByOrganizationModelKey = new HashMap<>();
				for (String key : keys) {
					int organizationId = ModelUtil.getIdFromKey(key);
					// We need to set the client ID for following method
					Env.setContext(contextCopy, Env.AD_CLIENT_ID, clientIdsByOrganizationId.get(organizationId));
					rolesByOrganizationModelKey.put(key,
							Arrays.stream(currentUser.getRoles(organizationId)).collect(Collectors.toList()));
				}

				return rolesByOrganizationModelKey;
			} finally {
				Repository.clearApplyAccessFilterNotNeeded();
				ServerContext.setCurrentInstance(batchLoaderEnvironment.getContext());
				PO.clearCrossTenantSafe();
			}
		});
	}

	private MappedBatchLoaderWithContext<String, List<X_AD_Role>> getByUserIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			String modelName = ModelUtil.getModelFromKey(keys.iterator().next());
			// Batch call to get user roles
			Set<Integer> userIds = keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet());

			Map<Integer, List<MUserRoles>> userRoleAssignmentsByUserId =
					Repository.getGroupsByIds(batchLoaderEnvironment.getContext(), MUserRoles.Table_Name, null,
							MUserRoles::getAD_User_ID, MUserRoles.COLUMNNAME_AD_User_ID, userIds);

			// batch call to get roles
			Set<Integer> roleIds = userRoleAssignmentsByUserId.values().stream()
					.flatMap(roleByUserId -> roleByUserId.stream().map(MUserRoles::getAD_Role_ID))
					.collect(Collectors.toSet());
			Map<Integer, X_AD_Role> rolesById =
					Repository.getByIds(batchLoaderEnvironment.getContext(), X_AD_Role.Table_Name, null, roleIds);

			return userRoleAssignmentsByUserId.entrySet().stream().collect(
					Collectors.toMap(entry -> ModelUtil.getModelKey(modelName, entry.getKey()),
							entry -> entry.getValue().stream().map(userRole -> rolesById.get(userRole.getAD_Role_ID()))
									.collect(Collectors.toList())));
		});
	}
}
