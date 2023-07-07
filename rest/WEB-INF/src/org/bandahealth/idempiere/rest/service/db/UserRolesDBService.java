package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.model.UserRoles;
import org.compiere.model.MRole;
import org.compiere.model.MUserRoles;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserRolesDBService extends BaseDBService<UserRoles, MUserRoles> {

	@Autowired
	private RoleDBService roleDBService;

	public void saveRoles(MUser_BH user, List<Role> roles) {
		// get roles
		Set<Integer> roleIdsToSave =
				roleDBService.getByUuids(roles.stream().map(Role::getUuid).collect(Collectors.toSet())).values().stream()
						.map(MRole::getAD_Role_ID).collect(Collectors.toSet());

		// check existing user roles
		List<MUserRoles> existingUserRoles =
				new Query(Env.getCtx(), MUserRoles.Table_Name, MUserRoles.COLUMNNAME_AD_User_ID + " =?", null).setParameters(
						user.get_ID()).list();
		Set<Integer> existingRoleIds =
				existingUserRoles.stream().map(MUserRoles::getAD_Role_ID).collect(Collectors.toSet());

		existingUserRoles.stream().filter(userRole -> !roleIdsToSave.contains(userRole.getAD_Role_ID()))
				.forEach(userRole -> userRole.deleteEx(true));

		// save new roles
		roleIdsToSave.stream().filter(roleIdToSave -> !existingRoleIds.contains(roleIdToSave)).forEach(roleIdToSave -> {
			try {
				MUserRoles mUserRoles = new MUserRoles(Env.getCtx(), 0, null);
				mUserRoles.setAD_User_ID(user.get_ID());
				mUserRoles.setAD_Role_ID(roleIdToSave);
				mUserRoles.saveEx();
			} catch (Exception ex) {
				log.severe(ex.getMessage());
			}
		});
	}

	@Override
	public UserRoles saveEntity(UserRoles entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected UserRoles createInstanceWithDefaultFields(MUserRoles instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected UserRoles createInstanceWithAllFields(MUserRoles instance) {
		return new UserRoles(instance);
	}

	@Override
	protected UserRoles createInstanceWithSearchFields(MUserRoles instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MUserRoles getModelInstance() {
		return new MUserRoles(Env.getCtx(), 0, null);
	}
}
