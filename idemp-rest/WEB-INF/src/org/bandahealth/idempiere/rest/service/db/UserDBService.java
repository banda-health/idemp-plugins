package org.bandahealth.idempiere.rest.service.db;

import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.stream.Collectors;

import javax.management.relation.RoleList;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.exceptions.DuplicateEntitySaveException;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Role;
import org.bandahealth.idempiere.rest.model.User;
import org.compiere.model.MClient;
import org.compiere.model.MRefList;
import org.compiere.model.MRole;
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class UserDBService extends BaseDBService<User, MUser_BH> {
	private static final int SYSTEM_USER_ID = 100;
	private static final int SYSTEM_ADMIN_ORG_ID = 0;
	
	public BaseListResponse<User> getCliniciansResponse(Paging pagingInfo) {
		List<User> results = new ArrayList<>();

		List<MUser_BH> entities = getClinicians(pagingInfo);
		if (!entities.isEmpty()) {
			for (MUser_BH entity : entities) {
				results.add(createInstanceWithDefaultFields(entity));
			}
		}

		return new BaseListResponse<User>(results, pagingInfo);
	}
	
	public BaseListResponse<User> getNonAdmins(Paging pagingInfo, String sortColumn, String sortOrder, String filterJson) {		
		MRole[] clientRoles =  MRole.getOfClient(Env.getCtx());
		int clientId = Env.getAD_Client_ID(Env.getCtx());
		
		Map<Integer, MRole> clientRoleIdMap = new HashMap<>();
		
		for(MRole role: clientRoles) {
			clientRoleIdMap.put(role.getAD_Role_ID(), role);
		}
		
		String sql = "SELECT u.ad_user_uu, u.created, u.name, ur.ad_role_id, u.datelastlogin, " 
				  + " u.isactive, u.ad_org_id, u.ad_client_id, u.ad_org_id " 
				  + " FROM ad_user u "
				  + " JOIN AD_User_Roles ur ON u.ad_user_id = ur.ad_user_id "
				  + " WHERE u.ad_org_id != 0 "
				  + " AND u.ad_client_id = '"+ clientId +" ' ";
		
		Map<String, User> usersRolesMap = new HashMap<>();
				
		SqlUtil.executeQuery(sql, null, sql, rs -> {
		 try {
			 String uuid = rs.getString(1);
			 Timestamp created = rs.getTimestamp(2);
			 String name = rs.getString(3);
			 int roleId = rs.getInt(4);
			 Timestamp lastLogin = rs.getTimestamp(5);
			 boolean isActive = rs.getBoolean(6);
			 
			 List<Role> roleList = new ArrayList<Role>();
			 Role userRole = new Role(clientRoleIdMap.get(roleId));
			 
			 if(usersRolesMap.containsKey(uuid)) {
				 User existingUser = usersRolesMap.get(uuid);
				 existingUser.roles.add(userRole);
				 usersRolesMap.put(uuid, existingUser);
			 } else {
				 roleList.add(userRole);
				 User user = new User(name, uuid, created, lastLogin, isActive, roleList);
				 usersRolesMap.put(uuid, user);
			 }
		 } catch(SQLException e) {
			 log.log(Level.SEVERE, sql, e);
		 }
		});
		
		if (pagingInfo != null) {
			pagingInfo.setTotalRecordCount(usersRolesMap.size());
		}

		return new BaseListResponse<User>(new ArrayList<User>(usersRolesMap.values()), pagingInfo);
	}

	public List<MUser_BH> getClinicians(Paging pagingInfo) {
		StringBuilder whereClause =
				new StringBuilder(MUser_BH.Table_Name + "." + MUser_BH.COLUMNNAME_AD_User_ID + " != ?"); // exclude superuser
		whereClause.append(" AND ");
		whereClause.append(MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_Role_ID + " IN (");
		whereClause.append("(SELECT " + MRole.COLUMNNAME_AD_Role_ID + " FROM " + MRole.Table_Name);
		whereClause.append(" WHERE " + MRole.COLUMNNAME_Name);
		whereClause.append(" = ? AND ");
		whereClause.append(MRole.COLUMNNAME_AD_Client_ID + " =? ))");

		StringBuilder joinClause = new StringBuilder(" JOIN " + MUserRoles.Table_Name);
		joinClause.append(" ON ");
		joinClause.append(MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_User_ID);
		joinClause.append(" = ");
		joinClause.append(MUser_BH.Table_Name + "." + MUser_BH.COLUMNNAME_AD_User_ID);

		// get client name
		MClient client = MClient.get(Env.getCtx(), Env.getAD_Client_ID(Env.getCtx()));
		// Now get the clinician role suffix
		MRefList clinicianRoleSuffix = new Query(Env.getCtx(), MRefList.Table_Name,
				MRefList.Table_Name + "." + MRefList.COLUMNNAME_Value + "=? AND " + MReference_BH.Table_Name + "." +
						MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", null).addJoinClause(" JOIN " +
				MReference_BH.Table_Name + " ON " + MReference_BH.Table_Name + "." + MReference_BH.COLUMNNAME_AD_Reference_ID +
				"=" + MRefList.Table_Name + "." + MRefList.COLUMNNAME_AD_Reference_ID).setParameters(
				MBHDefaultIncludedRole.DB_USERTYPE_Clinician, MReference_BH.USER_TYPE_AD_REFERENCE_UU).first();
		if (clinicianRoleSuffix == null) {
			return new ArrayList<>();
		}
		String searchRoleName = client.getName() + " " + clinicianRoleSuffix.getName();

		Query query = new Query(Env.getCtx(), MUser_BH.Table_Name, whereClause.toString(), null)
				.setParameters(SYSTEM_USER_ID, searchRoleName, Env.getAD_Client_ID(Env.getCtx()))
				.setOnlyActiveRecords(true).setClient_ID().addJoinClause(joinClause.toString());

		if (pagingInfo != null) {
			pagingInfo.setTotalRecordCount(query.count());
		}

		return query.list();
	}

	@Override
	public User saveEntity(User entity) {
//		throw new AdempiereException("Operation not allowed");
		try {
			System.out.println("saving user status");
			MUser_BH user = getEntityByUuidFromDB(entity.getUuid());
			user.setIsActive(entity.getIsActive());
			user.saveEx();
			return null;
		}
		catch (Exception ex) {
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
			return new User(instance.getName(), instance.getAD_User_UU(), instance.getCreated(), instance.getDateLastLogin());
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
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
}
