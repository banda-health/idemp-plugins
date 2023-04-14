package org.bandahealth.idempiere.webui;

import java.util.List;

import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.MUserRoles;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class RoleAndUserManagement {

	private final static String ALL_SUBROLES_INCLUDED = "BandaGo Admin";
	private static Query query = new Query(Env.getCtx(), MRole.Table_Name,
	        MRoleIncluded.Table_Name + "." + MRoleIncluded.COLUMNNAME_AD_Role_ID + "= ?", null).addJoinClause(
	                "JOIN " + MRoleIncluded.Table_Name + " ON " + MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Role_ID
	                        + "=" + MRoleIncluded.Table_Name + "." + MRoleIncluded.COLUMNNAME_Included_Role_ID);

	public static boolean checkRoleHasAllSubRolesIncluded(Integer roleId) {

		List<MRole> subRolesIncludedInRole = 
		                query.setParameters(roleId).list();
		for (MRole subRole : subRolesIncludedInRole) {
			if (subRole.get_ValueAsString(MRole.COLUMNNAME_Name).equalsIgnoreCase(ALL_SUBROLES_INCLUDED)) {
				return true;
			}
		}
		return false;
	}

	public static boolean userRoleHasSpecificSubRoles(Integer roleId, Integer userId, Integer buttonRoleId) {
		boolean hasRoleAssigned = false;

		List<MRoleIncluded> subRolesIncludedInRole = new Query(Env.getCtx(), MRoleIncluded.Table_Name,
		        MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_Role_ID + "=" + roleId + " AND "
		                + MUserRoles.COLUMNNAME_AD_User_ID + "=" + userId,
		        null).addJoinClause(
		                "JOIN " + MRole.Table_Name + " ON " + MRoleIncluded.Table_Name + "."
		                        + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + MRole.Table_Name + "."
		                        + MRole.COLUMNNAME_AD_Role_ID)
		                .addJoinClause("JOIN " + MUserRoles.Table_Name + " ON " + MRoleIncluded.Table_Name + "."
		                        + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + MUserRoles.Table_Name + "."
		                        + MUserRoles.COLUMNNAME_AD_Role_ID)
		                .list();

		for (MRoleIncluded subRole : subRolesIncludedInRole) {
			if (buttonRoleId == subRole.get_ValueAsInt(MRoleIncluded.COLUMNNAME_Included_Role_ID)) {
				hasRoleAssigned = true;
			} else {
				continue;
			}
		}
		return hasRoleAssigned;
	}

	public static String appendRoleScriptString() {
		String scriptString = "";
		if (isUserViewingAnOrganization()) {
			scriptString = "requirejs(['user/organization'], function () {});";
		} else if (isUserViewingAClient()) {
			scriptString = "requirejs(['user/client'], function () {});";
		}
		return scriptString;
	}

	private static Boolean isUserViewingAnOrganization() {
		Boolean isViewingAnOrganization = true;
		if (Env.getAD_Org_ID(Env.getCtx()) == QueryConstants.BASE_ORGANIZATION_ID) {
			isViewingAnOrganization = false;
		}
		return isViewingAnOrganization;
	}

	private static boolean isUserViewingAClient() {
		Boolean isViewingAClient = false;
		if (Env.getAD_Org_ID(Env.getCtx()) == QueryConstants.BASE_ORGANIZATION_ID
		        && Env.getAD_Client_ID(Env.getCtx()) != QueryConstants.BASE_CLIENT_ID) {
			isViewingAClient = true;
		}
		return isViewingAClient;
	}
}
