package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class RoleDBService extends BaseDBService<Role, MRole> {
	@Autowired
	private IncludedRoleDBService includedRoleDBService;
	@Autowired
	private RoleOrganizationAccessDBService roleOrganizationAccessDBService;

	@Override
	public Role saveEntity(Role entity) {
		// check if role is present
		MRole role = getEntityByUuidFromDB(entity.getUuid());
		if (role == null) {
			role = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				role.setAD_Role_UU(entity.getUuid());
			}
		}

		// All roles do not need an org
		role.setAD_Org_ID(0);
		role.setIsManual(true);
		role.setName(entity.getName());
		role.setIsMasterRole(entity.isMasterRole());
		role.setUserLevel(MRole.USERLEVEL_Organization);
		role.saveEx();

		roleOrganizationAccessDBService.giveRoleAccessToOrganizationOfLoggedInClient(role);

		// check included roles
		Map<String, MRole> rolesToInclude =
				getByUuids(entity.getIncludedRoles().stream().map(Role::getUuid).collect(Collectors.toSet()));
		Set<Integer> idsOfRolesToInclude = rolesToInclude.values().stream().map(MRole::get_ID).collect(Collectors.toSet());

		List<MRoleIncluded> currentIncludedRoles =
				new Query(Env.getCtx(), MRoleIncluded.Table_Name, MRoleIncluded.COLUMNNAME_AD_Role_ID + " = ?",
						null).setParameters(role.get_ID()).list();
		Map<Integer, MRoleIncluded> currentIncludedRolesByIncludedRoleId = currentIncludedRoles.stream()
				.collect(Collectors.toMap(MRoleIncluded::getIncluded_Role_ID, currentlyIncludedRole -> currentlyIncludedRole));

		// remove ones that are no longer present
		currentIncludedRoles.stream()
				.filter(includedRole -> !idsOfRolesToInclude.contains(includedRole.getIncluded_Role_ID()))
				.forEach(includedRoleToRemove -> includedRoleToRemove.deleteEx(true));

		final MRole finalRole = role;
		final AtomicInteger sequenceNumber = new AtomicInteger(10);
		// add to add included roles
		rolesToInclude.values()
				.forEach(roleToInclude -> {
					MRoleIncluded includedRole = currentIncludedRolesByIncludedRoleId.getOrDefault(roleToInclude.get_ID(),
							new MRoleIncluded(Env.getCtx(), 0, null));
					includedRole.setAD_Org_ID(0);
					includedRole.setAD_Role_ID(finalRole.get_ID());
					includedRole.setIncluded_Role_ID(roleToInclude.get_ID());
					includedRole.setSeqNo(sequenceNumber.get());
					sequenceNumber.set(sequenceNumber.get() + 10);
					includedRole.saveEx();
				});

		role.loadAccess(true);
		return transformData(Collections.singletonList(getEntityByUuidFromDB(role.getAD_Role_UU()))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected Role createInstanceWithDefaultFields(MRole instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Role createInstanceWithAllFields(MRole instance) {
		return new Role(instance);
	}

	@Override
	protected MRole getModelInstance() {
		return new MRole(Env.getCtx(), 0, null);
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
		return new EntityConfiguration() {
			{
				setShouldUseContextClientId(true);
				setShouldFetchFromSystemClient(true);
			}
		};
	}

	@Override
	public List<Role> transformData(List<MRole> dbModels) {
		Map<Integer, List<MRoleIncluded>> includedRolesByRoleId =
				includedRoleDBService.getGroupsByIds(MRoleIncluded::getAD_Role_ID, MRoleIncluded.COLUMNNAME_AD_Role_ID,
						dbModels.stream().map(MRole::get_ID).collect(Collectors.toSet()));
		Map<Integer, MRole> rolesToIncludeById = getByIds(
				includedRolesByRoleId.values().stream().flatMap(Collection::stream).map(MRoleIncluded::getIncluded_Role_ID)
						.collect(Collectors.toSet()));
		return dbModels.stream().map(dbModel -> {
			Role role = createInstanceWithAllFields(dbModel);
			if (includedRolesByRoleId.containsKey(dbModel.get_ID())) {
				role.setIncludedRoles(includedRolesByRoleId.get(dbModel.get_ID()).stream().map(
								includedRole -> createInstanceWithAllFields(rolesToIncludeById.get(includedRole.getIncluded_Role_ID())))
						.collect(Collectors.toList()));
			}
			return role;
		}).collect(Collectors.toList());
	}
}
