package org.bandahealth.idempiere.rest.service.db;

import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Expense;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.User;
import org.compiere.model.MClient;
import org.compiere.model.MRefList;
import org.compiere.model.MRole;
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
		StringBuilder whereClause = 
			new StringBuilder(MUser_BH.Table_Name + "." + MUser_BH.COLUMNNAME_AD_User_ID + " != ?"); // exclude superuser
			whereClause.append(" AND ");
			whereClause.append(MUser_BH.Table_Name + "." + MRole.COLUMNNAME_AD_Client_ID + " != ? "); // exclude admin
			whereClause.append(" AND ");
			whereClause.append(MUser_BH.Table_Name + "." + MRole.COLUMNNAME_AD_Org_ID + " = ? ");
			
		StringBuilder joinClause = new StringBuilder(" JOIN " + MUserRoles.Table_Name);
			joinClause.append(" ON ");
			joinClause.append(MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_User_ID);
			joinClause.append(" = ");
			joinClause.append(MUser_BH.Table_Name + "." + MUser_BH.COLUMNNAME_AD_User_ID);

		Query query = new Query(Env.getCtx(), MUser_BH.Table_Name, whereClause.toString(), null)
			.setParameters(SYSTEM_USER_ID, SYSTEM_ADMIN_ORG_ID, Env.getAD_Org_ID(Env.getCtx()))
			.addJoinClause(joinClause.toString());
		
		List<User> results = new ArrayList<>();
		
		String sql = "SELECT u.ad_user_uu, u.created, u.name, ad_role.name, u.datelastlogin, " 
				  + " u.isactive, u.ad_org_id, u.ad_client_id, u.ad_org_id " 
				  + " FROM ad_user u "
				  + " JOIN AD_User_Roles ur ON u.ad_user_id = ur.ad_user_id "
				  + " JOIN ad_role on ur.ad_role_id = ad_role.ad_role_id "
				  + " where u.ad_org_id != 0 "
				  + " AND u.ad_client_id = '1000000' ";
		
		Map<String, User> usersRoles = new HashMap<>();
		
		SqlUtil.executeQuery(sql, null, sql, rs -> {
		 try {
			 String uuid = rs.getString(1);
			 Timestamp created = rs.getTimestamp(2);
			 String name = rs.getString(3);
			 String roleName = rs.getString(4);
			 Timestamp lastLogin = rs.getTimestamp(5);
			 boolean isActive = rs.getBoolean(6);
			 
			 if(usersRoles.containsKey(uuid)) {
				 
			 } else {
				 MRole role = new MRole(null, rs, null);
				 usersRoles.put(uuid, new User(name, uuid, created, lastLogin, isActive));
			 }
		 } catch(SQLException e) {
			 log.log(Level.SEVERE, sql, e);
		 }
		});

		List<MUser_BH> entities = query.list();

//		List<Integer> productIdsWithStock =
//				entities.stream(). .keySet().stream().map(MProduct_BH::get_ID).collect(Collectors.toList());
//		List<String> matchingIds = entities.stream().map(user -> Integer.toString(user.getAD_User_ID())).collect(Collectors.toList());
		
		if (!entities.isEmpty()) {
			for (MUser_BH entity : entities) {
				results.add(createInstanceWithAllFields(entity));
			}
		}

		return new BaseListResponse<User>(new ArrayList<User>(usersRoles.values()), pagingInfo);
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
		throw new AdempiereException("Operation not allowed");
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
