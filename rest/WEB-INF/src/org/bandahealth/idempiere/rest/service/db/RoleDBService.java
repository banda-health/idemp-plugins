package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class RoleDBService extends BaseDBService<Role, MRole> {

	@Override
	public Role saveEntity(Role entity) {
		// check if role is present
		MRole mRole = getEntityByUuidFromDB(entity.getUuid());
		if (mRole == null) {
			mRole = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				mRole.setAD_Role_UU(entity.getUuid());
			}
		}

		mRole.setName(entity.getName());
		mRole.setIsMasterRole(entity.isMasterRole());
		mRole.saveEx();

		// check included roles
		Set<String> includedRolesUuids = entity.getIncludedRoles().stream().map(Role::getUuid)
				.collect(Collectors.toSet());

		Map<String, MRole> mIncludedRoles = getByUuids(includedRolesUuids);

		List<MRoleIncluded> roleIncludedList = new Query(Env.getCtx(), MRole.Table_Name,
				MRoleIncluded.COLUMNNAME_AD_Role_ID + " = ?", null).list();

		// remove existing ones
		roleIncludedList.stream().forEach(roleIncluded -> {
			roleIncluded.delete(true);
		});

		final MRole finalMRole = mRole;
		// add to add included roles
		entity.getIncludedRoles().stream()
				.forEach(includedRole -> {
					MRoleIncluded mRoleIncluded = new MRoleIncluded(Env.getCtx(), 0, null);
					mRoleIncluded.setAD_Role_ID(finalMRole.get_ID());
					mRoleIncluded.setIncluded_Role_ID(mIncludedRoles.get(includedRole.getUuid()).get_ID());
					mRoleIncluded.saveEx();
				});

		return transformData(Collections.singletonList(getEntityByUuidFromDB(entity.getUuid()))).get(0);
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
	protected Role createInstanceWithSearchFields(MRole instance) {
		return createInstanceWithAllFields(instance);
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
}
