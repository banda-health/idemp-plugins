package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRoleIncludedDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MUserRolesDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MWindowAccessDataLoader;
import org.bandahealth.idempiere.graphql.model.IncludedRoleWindowAccess;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.MUserRoles;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MRoleResolver extends X_AD_RoleResolver {

	public CompletableFuture<List<MRoleIncluded>> AD_Role_IncludedList(X_AD_Role entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRoleIncluded>> dataLoader = environment.getDataLoaderRegistry().getDataLoader(
				MRoleIncludedDataLoader.DATALOADER_AD_Role_Included_BY_AD_Role_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Role_ID()));
	}

	public CompletableFuture<List<MWindowAccess_BH>> AD_Window_AccessList(X_AD_Role entity,
			DataFetchingEnvironment environment) {
		final DataLoader<String, List<MWindowAccess_BH>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MWindowAccessDataLoader.DATALOADER_AD_Window_Access_BY_AD_Role_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Role_ID()));
	}

	public CompletableFuture<List<IncludedRoleWindowAccess>> IncludedRoleWindowAccessList(X_AD_Role entity,
			DataFetchingEnvironment environment) {
		final DataLoader<String, List<MWindowAccess_BH>> dataLoader =
				environment.getDataLoaderRegistry()
						.getDataLoader(MWindowAccessDataLoader.DATALOADER_AD_Window_Access_BY_AD_Role_ID);
		MRole userRole = MRole.get(BandaGraphQLContext.getCtx(environment), entity.getAD_Role_ID());
		List<MRole> allUserRoles = userRole.getIncludedRoles(true);
		allUserRoles.add(userRole);
		List<Integer> roleIds = allUserRoles.stream().map(MRole::getAD_Role_ID).collect(Collectors.toList());
		return dataLoader.loadMany(
				roleIds.stream().map(roleId -> ModelUtil.getModelKey(entity, roleId)).collect(Collectors.toList())).thenApply(
				windowAccessLists -> {
					// Get the window access list
					List<MWindowAccess_BH> windowAccessList =
							windowAccessLists.stream().filter(Objects::nonNull).flatMap(Collection::stream).filter(Objects::nonNull)
									.collect(Collectors.toList());
					Map<Integer, List<MWindowAccess_BH>> windowAccessListsByWindow =
							windowAccessList.stream().collect(Collectors.groupingBy(MWindowAccess_BH::getAD_Window_ID));


					List<IncludedRoleWindowAccess> includedRoleWindowAccessList = new ArrayList<>();
					for (Map.Entry<Integer, List<MWindowAccess_BH>> windowAccessEntry : windowAccessListsByWindow.entrySet()) {
						IncludedRoleWindowAccess includedRoleWindowAccess = new IncludedRoleWindowAccess();
						includedRoleWindowAccess.setAD_Window_ID(windowAccessEntry.getKey());
						if (windowAccessEntry.getValue().stream().anyMatch(MWindowAccess_BH::isReadWrite)) {
							includedRoleWindowAccess.setIsReadWrite(true);
							if (windowAccessEntry.getValue().stream().anyMatch(MWindowAccess_BH::isBH_CanDeactivate)) {
								includedRoleWindowAccess.setBH_CanDeactivate(true);
							}
						}
						includedRoleWindowAccessList.add(includedRoleWindowAccess);
					}
					return includedRoleWindowAccessList;
				});
	}

	public CompletableFuture<List<MUserRoles>> AD_User_Roles(X_AD_Role entity, DataFetchingEnvironment environment) {
		DataLoader<String, List<MUserRoles>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(MUserRolesDataLoader.DATALOADER_AD_User_Roles_BY_AD_Role_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Role_ID()));
	}
}
