package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Role_IncludedInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.util.Env;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

public class MRoleIncludedMutation extends X_AD_Role_IncludedMutation {
	@Override
	public MRoleIncluded AD_Role_IncludedSave(I_AD_Role_IncludedInput entity, DataFetchingEnvironment environment) {
		MRoleIncluded includedRole = super.AD_Role_IncludedSave(entity, environment);
		refreshRoleAccess(Collections.singleton(entity.getAD_Role_ID()), environment);
		return includedRole;
	}

	@Override
	public List<MRoleIncluded> AD_Role_IncludedSaveMany(List<I_AD_Role_IncludedInput> entities,
			DataFetchingEnvironment environment) {
		List<MRoleIncluded> includedRoles = super.AD_Role_IncludedSaveMany(entities, environment);
		refreshRoleAccess(entities.stream().map(I_AD_Role_IncludedInput::getAD_Role_ID).collect(Collectors.toSet()),
				environment);
		return includedRoles;
	}

	@Override
	public boolean AD_Role_IncludedDelete(List<String> uuids, DataFetchingEnvironment environment) {
		// Get the roles that need to be updated
		Set<Integer> roleIdsToRefreshAfterDelete =
				Repository.getByUuids(BandaGraphQLContext.getCtx(environment), getTableName(), null, new HashSet<>(uuids))
						.values().stream().map(includedRole -> ((MRoleIncluded) includedRole).getAD_Role_ID())
						.collect(Collectors.toSet());
		boolean wasDeleteSuccessful = super.AD_Role_IncludedDelete(uuids, environment);
		if (wasDeleteSuccessful) {
			refreshRoleAccess(roleIdsToRefreshAfterDelete, environment);
		}
		return wasDeleteSuccessful;
	}

	/**
	 * This reloads the access so that future queries of the role get the right stuff
	 *
	 * @param roleUuidsToReload
	 * @param environment
	 */
	private void refreshRoleAccess(Set<Integer> roleUuidsToReload, DataFetchingEnvironment environment) {
		Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
		roleUuidsToReload.forEach(
				roleId -> MRole.get(idempiereProperties, roleId, Env.getAD_User_ID(idempiereProperties), true));
	}
}
