package org.bandahealth.idempiere.webui.util;

import java.util.List;

import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class RoleAndUserManagement {
	
	private final static String ALL_SUBROLES_INCLUDED = "allRoles";

	public static boolean userRoleHasAllSubRolesIncluded(Integer roleId) {

		List<MRole> subRolesIncludedInRole = new Query(Env.getCtx(), MRole.Table_Name,
		        MRoleIncluded.Table_Name + "." + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + roleId, null)
		                .addJoinClause("JOIN " + MRoleIncluded.Table_Name + " ON " + MRole.Table_Name + "."
		                        + MRole.COLUMNNAME_AD_Role_ID + "=" + MRoleIncluded.Table_Name + "."
		                        + MRoleIncluded.COLUMNNAME_Included_Role_ID)
		                .list();
		for (MRole subRole : subRolesIncludedInRole) {
			if (subRole.get_ValueAsString(MRole.COLUMNNAME_Name).equalsIgnoreCase(ALL_SUBROLES_INCLUDED)) {
				return true;
			}
		}
		return false;
	}
}
