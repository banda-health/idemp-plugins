package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.MWindowAccessDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRole;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MRoleResolver extends X_AD_RoleResolver {

	public CompletableFuture<List<X_AD_Role>> IncludedRoles(X_AD_Role entity,
			DataFetchingEnvironment environment) {
		return CompletableFuture.supplyAsync(() -> List.copyOf(
				MRole.get(BandaGraphQLContext.getCtx(environment), entity.getAD_Role_ID()).getIncludedRoles(true)));
	}

	public CompletableFuture<List<MWindowAccess_BH>> AD_Window_AccessList(X_AD_Role entity,
			DataFetchingEnvironment environment) {
		final DataLoader<String, List<MWindowAccess_BH>> dataLoader =
				environment.getDataLoaderRegistry()
						.getDataLoader(MWindowAccessDataLoader.AD_Window_access_BY_ROLE_ID_DATA_LOADER);
		MRole userRole = MRole.get(BandaGraphQLContext.getCtx(environment), entity.getAD_Role_ID());
		List<MRole> allUserRoles = userRole.getIncludedRoles(true);
		allUserRoles.add(userRole);
		List<Integer> roleIds = allUserRoles.stream().map(MRole::getAD_Role_ID).collect(Collectors.toList());
		return dataLoader.loadMany(
				roleIds.stream().map(roleId -> ModelUtil.getModelKey(entity, roleId)).collect(Collectors.toList())).thenApply(
				windowAccessLists -> windowAccessLists.stream().filter(Objects::nonNull).flatMap(Collection::stream)
						.filter(Objects::nonNull).collect(Collectors.toList()));
	}
}
