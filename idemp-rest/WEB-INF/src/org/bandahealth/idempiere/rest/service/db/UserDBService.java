package org.bandahealth.idempiere.rest.service.db;

import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MRole_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.utils.FilterUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
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
import org.springframework.stereotype.Component;

@Component
public class UserDBService extends BaseDBService<User, MUser_BH> {
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
		MRole[] clientRoles = MRole.getOfClient(Env.getCtx());
		int clientId = Env.getAD_Client_ID(Env.getCtx());

		Map<Integer, MRole> clientRoleIdMap = new HashMap<>();

		for (MRole role : clientRoles) {
			clientRoleIdMap.put(role.getAD_Role_ID(), role);
		}

		StringBuilder sqlQuery = new StringBuilder().append(" SELECT ").append(MUser_BH.Table_Name).append(".")
				.append(MUser_BH.COLUMNNAME_AD_User_UU).append(",").append(MUser_BH.Table_Name).append(".")
				.append(MUser_BH.COLUMNNAME_Created).append(",").append(MUser_BH.Table_Name).append(".")
				.append(MUser_BH.COLUMNNAME_Name).append(",")

				.append(MUserRoles.Table_Name).append(".").append(MUserRoles.COLUMNNAME_AD_Role_ID).append(",")

				.append(MUser_BH.Table_Name).append(".").append(MUser_BH.COLUMNNAME_DateLastLogin).append(",")
				.append(MUser_BH.Table_Name).append(".").append(MUser_BH.COLUMNNAME_IsActive).append(",")
				.append(MUser_BH.Table_Name).append(".").append(MUser_BH.COLUMNNAME_AD_Org_ID).append(",")
				.append(MUser_BH.Table_Name).append(".").append(MUser_BH.COLUMNNAME_AD_Client_ID)

				.append(" FROM ").append(MUser_BH.Table_Name).append(" JOIN ").append(MUserRoles.Table_Name)
				.append(" ON ").append(MUser_BH.Table_Name).append(".").append(MUser_BH.COLUMNNAME_AD_User_ID)
				.append("=").append(MUserRoles.Table_Name).append(".").append(MUserRoles.COLUMNNAME_AD_User_ID)

				.append(" WHERE ").append(MUser_BH.Table_Name).append(".").append(MUser_BH.COLUMNNAME_AD_Org_ID)
				.append("!=").append(SYSTEM_ADMIN_ORG_ID).append(" AND ").append(MUser_BH.Table_Name).append(".")
				.append(MUser_BH.COLUMNNAME_AD_Client_ID).append("=").append(clientId);

		List<Object> parameters = new ArrayList<>();
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(Env.getAD_Org_ID(Env.getCtx()));

		String filter = " AND "
				+ FilterUtil.getWhereClauseFromFilter(MUser_BH.Table_Name, filterJson, parameters, true);

		sqlQuery.append(filter);

		StringBuilder sqlOrderBy = new StringBuilder().append(" ORDER BY ");
		if (sortColumn != null && !sortColumn.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			sqlOrderBy.append(sortColumn).append(" ").append(sortOrder);
			sqlQuery.append(sqlOrderBy);
		}

		String sqlSelect = sqlQuery.toString(); // has to appear as final or effectively final

		Map<String, User> usersRolesMap = new LinkedHashMap<>();

		SqlUtil.executeQuery(sqlSelect, null, null, rs -> {
			try {
				String uuid = rs.getString(1);
				Timestamp created = rs.getTimestamp(2);
				String name = rs.getString(3);
				int roleId = rs.getInt(4);
				Timestamp lastLogin = rs.getTimestamp(5);
				boolean isActive = rs.getBoolean(6);

				List<Role> roleList = new ArrayList<Role>();
				Role userRole = new Role(clientRoleIdMap.get(roleId));

				// The result set contains repeated user details if user has more than one role
				// i.e Transforms [User_a : Cashier, User_a: Lab] -> [User_a : [Cashier, Lab]]
				if (usersRolesMap.containsKey(uuid)) {
					User existingUser = usersRolesMap.get(uuid);
					existingUser.getRoles().add(userRole);
					usersRolesMap.put(uuid, existingUser);
				} else {
					roleList.add(userRole);
					User user = new User(name, uuid, created, lastLogin, isActive, roleList);
					usersRolesMap.put(uuid, user);
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, sqlSelect, e);
			}
		});

		if (pagingInfo != null) {
			pagingInfo.setTotalRecordCount(usersRolesMap.size());
		}

		return new BaseListResponse<User>(new ArrayList<User>(usersRolesMap.values()), pagingInfo);
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
			
			if (StringUtil.isNotNullAndEmpty(entity.getResetPassword())){
				user.setPassword(entity.getResetPassword()); // will be hashed and validated on saveEx
				user.setIsExpired(true); // Force Change On Next Login
			}
			
			user.saveEx();
			return entity;
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
		try {
			return new User(instance.getName(), instance.getAD_User_UU());
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
			throw new RuntimeException(ex.getLocalizedMessage(), ex);
		}
	}

	@Override
	protected User createInstanceWithAllFields(MUser_BH instance) {
		try {
			return new User(instance.getName(), instance.getAD_User_UU(), instance.getCreated(),
					instance.getDateLastLogin());
		} catch (Exception ex) {
			log.severe("Error creating user instance: " + ex);
			throw new RuntimeException(ex.getLocalizedMessage(), ex);
		}
	}

	@Override
	protected User createInstanceWithSearchFields(MUser_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MUser_BH getModelInstance() {
		return new MUser_BH(Env.getCtx(), 0, null);
	}

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}
}