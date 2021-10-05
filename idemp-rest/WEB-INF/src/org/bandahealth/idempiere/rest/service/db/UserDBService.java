package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
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
	private static final int SYSTEM_ADMIN_CLIENT_ID = 0;
	
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
			whereClause.append(MUser_BH.Table_Name + "." + MRole.COLUMNNAME_AD_Org_ID + " = ? ");
			whereClause.append(" AND ");
			whereClause.append(MUser_BH.Table_Name + "." + MRole.COLUMNNAME_AD_Client_ID + " = ? ");
			
		StringBuilder joinClause = new StringBuilder(" JOIN " + MUserRoles.Table_Name);
			joinClause.append(" ON ");
			joinClause.append(MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_User_ID);
			joinClause.append(" = ");
			joinClause.append(MUser_BH.Table_Name + "." + MUser_BH.COLUMNNAME_AD_User_ID);

		Query query = new Query(Env.getCtx(), MUser_BH.Table_Name, whereClause.toString(), null)
			.setParameters(SYSTEM_USER_ID, SYSTEM_ADMIN_CLIENT_ID, Env.getAD_Client_ID(Env.getCtx()))
			.addJoinClause(joinClause.toString());
		
		List<User> results = new ArrayList<>();

		List<MUser_BH> entities = query.list();
		if (!entities.isEmpty()) {
			for (MUser_BH entity : entities) {
				results.add(createInstanceWithDefaultFields(entity));
			}
		}

		return new BaseListResponse<User>(results, pagingInfo);
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
		return createInstanceWithDefaultFields(instance);
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
