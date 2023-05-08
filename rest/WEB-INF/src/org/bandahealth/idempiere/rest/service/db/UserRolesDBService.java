package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.model.UserRoles;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.compiere.model.MRole;
import org.compiere.model.MUserRoles;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserRolesDBService extends BaseDBService<UserRoles, MUserRoles> {

	public void saveRoles(MUser_BH user, List<Role> roles) {
		// check if user has existing user roles..
		List<MUserRoles> existingUserRoles = Arrays.asList(MUserRoles.getOfUser(Env.getCtx(), user.get_ID()));

		Set<String> rolesUuids = roles.stream().map(Role::getUuid).collect(Collectors.toSet());
		List<Object> parameters = new ArrayList<>();

		String whereClause = MUserRoles.COLUMNNAME_AD_Role_ID + " IN (SELECT " + MRole.COLUMNNAME_AD_Role_ID + " FROM "
				+ MRole.Table_Name + " WHERE " + MRole.COLUMNNAME_AD_Role_UU + " IN("
				+ QueryUtil.getWhereClauseAndSetParametersForSet(rolesUuids, parameters) + "))";

		// check request user roles..
		List<MUserRoles> newUserRoles = new Query(Env.getCtx(), MUserRoles.Table_Name, whereClause, null).list();

		// save user roles
		newUserRoles.stream()
				.filter(userRole -> existingUserRoles.stream()
						.noneMatch(existingUserRole -> existingUserRole.get_ID() == userRole.get_ID()))
				.forEach(userRole -> {
					MUserRoles mUserRoles = new MUserRoles(Env.getCtx(), 0, null);
					mUserRoles.setAD_User_ID(user.get_ID());
					mUserRoles.setAD_Role_ID(userRole.get_ID());
					mUserRoles.saveEx();
				});

		// remove user roles which are not in the request
		existingUserRoles.stream().filter(
				userRole -> newUserRoles.stream().noneMatch(newUserRole -> newUserRole.get_ID() == userRole.get_ID()))
				.forEach(userRole -> {
					userRole.delete(true);
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
