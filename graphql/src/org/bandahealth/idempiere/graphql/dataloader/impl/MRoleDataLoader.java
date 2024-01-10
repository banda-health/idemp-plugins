package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MRoleDataLoader extends X_AD_RoleDataLoader {
	public static String AD_Role_BY_ORGANIZATION_ID_DATA_LOADER = "AD_RoleByOrganizationIdDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(AD_Role_BY_ORGANIZATION_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByOrganizationIdBatchLoader(), getOptionsWithCache(idempiereContext)));
	}

	/**
	 * Copied from {@link org.compiere.model.MUser#getRoles(int)}
	 *
	 * @return
	 */
	private MappedBatchLoaderWithContext<String, List<MRole>> getByOrganizationIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			ServerContext.setCurrentInstance(batchLoaderEnvironment.getContext());
			Set<Integer> organizationIds = keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet());

			// If the user is currently the system client, we can get everything
			if (Env.getAD_Client_ID(batchLoaderEnvironment.getContext()) == 0) {
				Repository.setApplyAccessFilterNotNeeded();
				PO.setCrossTenantSafe();
			}
			Map<Integer, Integer> clientIdsByOrganizationId =
					Repository.<MOrg>getByIds(batchLoaderEnvironment.getContext(), MOrg.Table_Name, null, organizationIds)
							.values().stream().collect(Collectors.toMap(PO::getAD_Org_ID, PO::getAD_Client_ID));

			// The following method uses the context, so set it
			MUser_BH currentUser =
					new MUser_BH(batchLoaderEnvironment.getContext(), Env.getAD_User_ID(batchLoaderEnvironment.getContext()),
							null);

			Map<String, List<MRole>> rolesByOrganizationModelKey = new HashMap<>();
			for (String key : keys) {
				int organizationId = ModelUtil.getIdFromKey(key);
				// We need to set the client ID for following method
				Env.setContext(batchLoaderEnvironment.getContext(), Env.AD_CLIENT_ID, clientIdsByOrganizationId.get(organizationId));
				rolesByOrganizationModelKey.put(key,
						Arrays.stream(currentUser.getRoles(organizationId)).collect(Collectors.toList()));
			}

			Repository.clearApplyAccessFilterNotNeeded();
			PO.clearCrossTenantSafe();
			return rolesByOrganizationModelKey;
		});
	}
}
