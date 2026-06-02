package org.bandahealth.idempiere.base.utils;

import java.util.Set;

public record FeatureFlagContext(int clientId, int orgId, int roleId, int userId, String environment,
		Set<Integer> applicableRoleIds, boolean systemAdministrator) {

	public FeatureFlagContext(int clientId, int orgId, int roleId, int userId, String environment) {
		this(clientId, orgId, roleId, userId, environment, null, false);
	}

	public Set<Integer> resolvedRoleIds() {
		if (applicableRoleIds != null && !applicableRoleIds.isEmpty()) {
			return applicableRoleIds;
		}
		return roleId > 0 ? Set.of(roleId) : Set.of();
	}
}
