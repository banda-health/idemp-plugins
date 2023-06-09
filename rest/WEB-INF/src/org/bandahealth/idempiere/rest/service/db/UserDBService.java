package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MRole_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.exceptions.DuplicateEntitySaveException;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.model.User;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.MUserRoles;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDBService extends BaseDBService<User, MUser_BH> {
	@Autowired
	private UserRolesDBService userRolesDBService;

	@Autowired
	private RoleDBService roleDBService;

	private static final int SYSTEM_ADMIN_ORG_ID = 0;

	private Map<String, String> dynamicJoins = new HashMap<>() {
		{
			put(MMovement_BH.Table_Name,
					"LEFT JOIN " + MMovement_BH.Table_Name + " ON " + MMovement_BH.Table_Name + "."
							+ MMovement_BH.COLUMNNAME_CreatedBy + " = " + MUser_BH.Table_Name + "."
							+ MUser_BH.COLUMNNAME_AD_User_ID);
		}
	};

	public BaseListResponse<User> getCliniciansResponse(Paging pagingInfo) {
		List<User> results = new ArrayList<>();

		List<MUser_BH> entities = getClinicians(pagingInfo);
		if (!entities.isEmpty()) {
			for (MUser_BH entity : entities) {
				results.add(createInstanceWithDefaultFields(entity));
			}
		}

		return new BaseListResponse<>(results, pagingInfo);
	}

	public BaseListResponse<User> getNonAdmins(Paging pagingInfo, String sortColumn, String sortOrder,
			String filterJson) {
		StringBuilder whereClause = new StringBuilder().append(MUser_BH.Table_Name).append(".")
				.append(MUser_BH.COLUMNNAME_AD_Org_ID).append("!=").append(SYSTEM_ADMIN_ORG_ID).append(" AND ")
				.append(MUser_BH.Table_Name).append(".").append(MUser_BH.COLUMNNAME_AD_Client_ID).append(" = ?");

		StringBuilder joinClause = new StringBuilder(" JOIN ").append(MUserRoles.Table_Name).append(" ON ")
				.append(MUser_BH.Table_Name).append(".").append(MUser_BH.COLUMNNAME_AD_User_ID).append("=")
				.append(MUserRoles.Table_Name).append(".").append(MUserRoles.COLUMNNAME_AD_User_ID);

		List<Object> parameters = new ArrayList<>();
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));

		return super.getAll(whereClause.toString(), parameters, pagingInfo, sortOrder, filterJson,
				joinClause.toString());
	}

	/**
	 * Get users assigned roles with clinician basic & advanced included roles
	 * 
	 * @param pagingInfo
	 * @return
	 */
	public List<MUser_BH> getClinicians(Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();

		String roleUuidClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				new HashSet<>(Arrays.asList(MRole_BH.CLINICIAN_ADVANCED_UU, MRole_BH.CLINICIAN_BASIC_UU)), parameters);

		parameters.add(Env.getAD_Client_ID(Env.getCtx()));

		String whereClause = MRoleIncluded.Table_Name + "." + MRoleIncluded.COLUMNNAME_Included_Role_ID + " IN (SELECT "
				+ MRole.COLUMNNAME_AD_Role_ID + " FROM " + MRole.Table_Name + " WHERE " + MRole.COLUMNNAME_AD_Role_UU
				+ " IN(" + roleUuidClause + ")) AND " + MUser_BH.Table_Name + "." + MUser_BH.COLUMNNAME_AD_Client_ID
				+ " =?";

		String joinClause = " JOIN " + MUserRoles.Table_Name + " ON " + MUser_BH.Table_Name + "."
				+ MUser_BH.COLUMNNAME_AD_User_ID + " = " + MUserRoles.Table_Name + "."
				+ MUserRoles.COLUMNNAME_AD_User_ID;

		joinClause += " JOIN " + MRole.Table_Name + " ON " + MUserRoles.Table_Name + "."
				+ MUserRoles.COLUMNNAME_AD_Role_ID + " = " + MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Role_ID;

		joinClause += " JOIN " + MRoleIncluded.Table_Name + " ON " + MRole.Table_Name + "."
				+ MRole.COLUMNNAME_AD_Role_ID + " = " + MRoleIncluded.Table_Name + "."
				+ MRoleIncluded.COLUMNNAME_AD_Role_ID;

		Query query = new Query(Env.getCtx(), MUser_BH.Table_Name, whereClause, null).addJoinClause(joinClause)
				.setParameters(parameters);

		if (pagingInfo != null) {
			pagingInfo.setTotalRecordCount(query.count());
		}

		return query.list();
	}

	@Override
	public User saveEntity(User entity) {
		try {
			MUser_BH user = getEntityByUuidFromDB(entity.getUuid());
			user.setIsActive(entity.getIsActive());

			if (StringUtil.isNotNullAndEmpty(entity.getResetPassword())) {
				user.setPassword(entity.getResetPassword()); // will be hashed and validated on saveEx
				user.setIsExpired(true); // Force Change On Next Login
			}

			user.setIsActive(entity.getIsActive());

			if (entity.getRoles() != null && !entity.getRoles().isEmpty()) {
				userRolesDBService.saveRoles(user, entity.getRoles());
			}

			user.saveEx();

			return transformData(Collections.singletonList(user)).get(0);

		} catch (Exception ex) {
			if (ex.getMessage().contains("Require unique data")) {
				throw new DuplicateEntitySaveException(ex.getLocalizedMessage());
			} else {
				throw new AdempiereException(ex.getLocalizedMessage());
			}
		}
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new AdempiereException("Operation not allowed");
	}

	@Override
	protected User createInstanceWithDefaultFields(MUser_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected User createInstanceWithAllFields(MUser_BH instance) {
		return new User(instance);
	}

	@Override
	protected User createInstanceWithSearchFields(MUser_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MUser_BH getModelInstance() {
		return new MUser_BH(Env.getCtx(), 0, null);
	}
	
	@Override
	public User getEntity(String uuid) {
		return transformData(Collections.singletonList(getEntityByUuidFromDB(uuid))).get(0);
	}

	@Override
	public List<User> transformData(List<MUser_BH> dbModels) {
		// Batch call to get user roles
		Set<Integer> userIds = dbModels.stream().map(MUser_BH::get_ID).collect(Collectors.toSet());

		Map<Integer, List<MUserRoles>> rolesByUserId = userRolesDBService.getGroupsByIds(MUserRoles::getAD_User_ID,
				MUserRoles.COLUMNNAME_AD_User_ID, userIds);

		// batch call to get roles
		Set<Integer> roleIds = rolesByUserId.values().stream()
				.flatMap(roleByUserId -> roleByUserId.stream().map(MUserRoles::getAD_Role_ID))
				.collect(Collectors.toSet());
		Map<Integer, MRole> roles = roleDBService.getByIds(roleIds);

		return dbModels.stream().map(mUser -> {
			User user = new User(mUser);
			if (rolesByUserId.containsKey(mUser.getAD_User_ID())) {
				// get user roles
				List<MUserRoles> userRoles = rolesByUserId.get(mUser.getAD_User_ID());
				// get roles
				userRoles.stream().forEach(userRole -> {
					// get role
					roles.values().stream().filter(role -> userRole.getAD_Role_ID() == role.get_ID()).forEach(role -> {
						Role r = new Role(role);
						user.getRoles().add(r);
					});
				});
			}

			return user;

		}).collect(Collectors.toList());
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}
}