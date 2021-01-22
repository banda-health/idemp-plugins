package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBandaSetup;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.User;
import org.compiere.model.MClient;
import org.compiere.model.MRole;
import org.compiere.model.MUser;
import org.compiere.model.MUserRoles;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class UserDBService extends BaseDBService<User, MUser> {

	public BaseListResponse<User> getClinicians(Paging pagingInfo) {
		List<User> results = new ArrayList<>();
		
		StringBuilder whereClause = new StringBuilder(MUser.Table_Name + "." + MUser.COLUMNNAME_AD_User_ID + " != ?"); // exclude superuser
		whereClause.append(" AND ");
		whereClause.append(MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_Role_ID + " IN (");
		whereClause.append("(SELECT " + MRole.COLUMNNAME_AD_Role_ID + " FROM " + MRole.Table_Name);
		whereClause.append(" WHERE " + MRole.COLUMNNAME_Name);
		whereClause.append(" = ? AND ");
		whereClause.append(MRole.COLUMNNAME_AD_Client_ID + " =? ))");
		
		StringBuilder joinClause = new StringBuilder("JOIN " + MUserRoles.Table_Name);
		joinClause.append(" ON ");
		joinClause.append(MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_User_ID);
		joinClause.append(" = ");
		joinClause.append(MUser.Table_Name + "." + MUser.COLUMNNAME_AD_User_ID);
		
		// get client name
		MClient client = MClient.get(Env.getCtx(), Env.getAD_Client_ID(Env.getCtx()));
		String searchRoleName = client.getName() + MBandaSetup.SUFFIX_CLINICIAN_USER_ROLE;
		Query query = new Query(Env.getCtx(), MUser.Table_Name, whereClause.toString(), null)
				.setParameters(100, searchRoleName, Env.getAD_Client_ID(Env.getCtx()))
				.setOnlyActiveRecords(true)
				.setClient_ID()
				.addJoinClause(joinClause.toString());
		
		pagingInfo.setTotalRecordCount(query.count());
		List<MUser> entities = query.list();
		if (!entities.isEmpty()) {
			for (MUser entity : entities) {
					results.add(createInstanceWithDefaultFields(entity));
			}
		}

		return new BaseListResponse<User>(results, pagingInfo);
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
	protected User createInstanceWithDefaultFields(MUser instance) {
		try {
			return new User(instance.getName(), instance.getAD_User_UU());
		} catch (Exception ex) {
			log.severe("Error creating product instance: " + ex);
			throw new RuntimeException(ex.getLocalizedMessage(), ex);
		}
	}

	@Override
	protected User createInstanceWithAllFields(MUser instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected User createInstanceWithSearchFields(MUser instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MUser getModelInstance() {
		return new MUser(Env.getCtx(), 0, null);
	}

}
