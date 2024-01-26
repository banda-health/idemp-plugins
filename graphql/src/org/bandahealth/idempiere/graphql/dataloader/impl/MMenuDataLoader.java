package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRole;
import org.compiere.model.X_AD_TreeNodeMM;
import org.compiere.util.Env;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoaderWithContext;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MMenuDataLoader extends X_AD_MenuDataLoader {
	public static String AD_Menu_BY_AD_MENU_PARENT_ID_DATA_LOADER = "AD_MenuByADMenuParentIdDataLoader";
	public static String AD_Menu_BY_AD_MENU_PARENT_UUID_DATA_LOADER = "AD_MenuByADMenuParentUuidDataLoader";

	@Override
	public void register(DataLoaderRegistry registry, Properties idempiereContext) {
		super.register(registry, idempiereContext);
		registry.register(AD_Menu_BY_AD_MENU_PARENT_ID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByParentMenuIdBatchLoader(), getOptionsWithoutCache(idempiereContext)));
		registry.register(AD_Menu_BY_AD_MENU_PARENT_UUID_DATA_LOADER,
				DataLoader.newMappedDataLoader(getByParentMenuUuidBatchLoader(), getOptionsWithoutCache(idempiereContext)));
	}

	private MappedBatchLoaderWithContext<String, List<MMenu_BH>> getByParentMenuIdBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			String modelName = ModelUtil.getModelFromKey(keys.iterator().next());
			Set<Integer> parentNodeIds = keys.stream().map(ModelUtil::getIdFromKey).collect(Collectors.toSet());

			Map<Integer, List<X_AD_TreeNodeMM>> mainMenuChildrenNodesByParentId =
					Repository.getGroupsByIds(batchLoaderEnvironment.getContext(), X_AD_TreeNodeMM.Table_Name, null,
							X_AD_TreeNodeMM::getParent_ID, X_AD_TreeNodeMM.COLUMNNAME_Parent_ID, parentNodeIds);
			Set<Integer> childrenIds =
					mainMenuChildrenNodesByParentId.values().stream().flatMap(Collection::stream).map(X_AD_TreeNodeMM::getNode_ID)
							.collect(Collectors.toSet());
			Map<Integer, MMenu_BH> childMenusById =
					Repository.getByIds(batchLoaderEnvironment.getContext(), MMenu_BH.Table_Name, null, childrenIds);
			//
			// TODO: Pull this logic from elsewhere, such as the MProcessDataLoader or MWindowDataLoader
			// Filter out menus that the user doesn't have access to based on window or process access
			MRole usersRole =
					MRole.get(batchLoaderEnvironment.getContext(), Env.getAD_Role_ID(batchLoaderEnvironment.getContext()));
			Map<Integer, MMenu_BH> finalChildMenusById = childMenusById.entrySet().stream().filter(entry ->
							(entry.getValue().getAD_Window_ID() == 0 ||
									usersRole.getWindowAccess(entry.getValue().getAD_Window_ID()) != null) &&
									(entry.getValue().getAD_Process_ID() == 0 ||
											usersRole.getProcessAccess(entry.getValue().getAD_Process_ID()) != null))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			return mainMenuChildrenNodesByParentId.entrySet().stream().collect(
					Collectors.toMap(entry -> ModelUtil.getModelKey(modelName, entry.getKey()),
							entry -> entry.getValue().stream()
									.map(treeNodeMM -> finalChildMenusById.getOrDefault(treeNodeMM.getNode_ID(), null))
									.filter(Objects::nonNull)
									.collect(Collectors.toList())));
		});
	}

	private MappedBatchLoaderWithContext<String, List<MMenu_BH>> getByParentMenuUuidBatchLoader() {
		return (keys, batchLoaderEnvironment) -> CompletableFuture.supplyAsync(() -> {
			Map<String, MMenu_BH> parentMenusByUuid =
					Repository.getByUuids(batchLoaderEnvironment.getContext(), MMenu_BH.Table_Name, null, keys);
			Map<Integer, MMenu_BH> parentMenusById =
					parentMenusByUuid.values().stream().collect(Collectors.toMap(MMenu_BH::getAD_Menu_ID, menu -> menu));
			Map<Integer, List<X_AD_TreeNodeMM>> mainMenuChildrenNodesByParentId =
					Repository.getGroupsByIds(batchLoaderEnvironment.getContext(), X_AD_TreeNodeMM.Table_Name, null,
							X_AD_TreeNodeMM::getParent_ID, X_AD_TreeNodeMM.COLUMNNAME_Parent_ID,
							parentMenusByUuid.values().stream().map(MMenu_BH::getAD_Menu_ID).collect(Collectors.toSet()));
			Set<Integer> childrenIds =
					mainMenuChildrenNodesByParentId.values().stream().flatMap(Collection::stream).map(X_AD_TreeNodeMM::getNode_ID)
							.collect(Collectors.toSet());
			Map<Integer, MMenu_BH> childMenusById =
					Repository.getByIds(batchLoaderEnvironment.getContext(), MMenu_BH.Table_Name, null, childrenIds);
			return mainMenuChildrenNodesByParentId.entrySet().stream().collect(
					Collectors.toMap(entry -> parentMenusById.get(entry.getKey()).getAD_Menu_UU(),
							entry -> entry.getValue().stream().map(treeNodeMM -> childMenusById.get(treeNodeMM.getNode_ID()))
									.collect(Collectors.toList())));
		});
	}
}
