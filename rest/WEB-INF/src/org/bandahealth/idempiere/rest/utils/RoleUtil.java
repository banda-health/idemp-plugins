package org.bandahealth.idempiere.rest.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.bandahealth.idempiere.rest.model.AccessLevel;
import org.compiere.model.MRole;
import org.compiere.model.MWindow;
import org.compiere.model.MWindowAccess;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Window_Access;
import org.compiere.util.Env;

import javax.naming.Context;

public class RoleUtil {

	public RoleUtil() {
	}

	/**
	 * Get the read-write and deactivate privileges set for windows assigned to this
	 * role
	 *
	 * @return Map of role windows with window-uuid and access privileges
	 */
	public static Map<String, AccessLevel> accessLevelsForRole() {

		List<Object> optionParams = new ArrayList<>();
		MRole userRole = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));

		List<MRole> allUserRoles = userRole.getIncludedRoles(true);
		allUserRoles.add(userRole);
		List<Integer> roleIds = allUserRoles.stream().map(MRole::getAD_Role_ID).collect(Collectors.toList());

		// Get all the windows assigned to this role
		String roleInClause = QueryUtil.getWhereClauseAndSetParametersForSet(new HashSet<>(roleIds), optionParams);
		String whereClause =
				MWindowAccess_BH.Table_Name + "." + MWindowAccess_BH.COLUMNNAME_AD_Role_ID + " IN (" + roleInClause + ")";

		Query queryWindows = new Query(Env.getCtx(), MWindow.Table_Name, whereClause, null).setParameters(optionParams)
				.addJoinClause(" JOIN " + MWindowAccess_BH.Table_Name + " ON " + MWindow.Table_Name + "."
						+ MWindow.COLUMNNAME_AD_Window_ID + "=" + MWindowAccess_BH.Table_Name + "."
						+ MWindowAccess_BH.COLUMNNAME_AD_Window_ID);
		List<MWindow> results = queryWindows.list();

		final Map<Integer, MWindow> windowsSetForRole = results.stream()
				.collect(Collectors.toMap(MWindow::get_ID, window -> window, (existing, replacement) -> existing));

//		// get list of read/write and deactivate window access for each window
		Query queryWindowAccess = new Query(Env.getCtx(), MWindowAccess.Table_Name,
				MWindowAccess_BH.Table_Name + "." + MWindowAccess_BH.COLUMNNAME_AD_Role_ID + " IN (" + roleInClause
						+ ")",
				null).setParameters(optionParams)
				.addJoinClause(" JOIN " + MRole.Table_Name + " ON " + MWindowAccess_BH.Table_Name + "."
						+ MWindowAccess_BH.COLUMNNAME_AD_Role_ID + "=" + MRole.Table_Name + "."
						+ MRole.COLUMNNAME_AD_Role_ID);
		List<MWindowAccess_BH> windowAccessList = queryWindowAccess.list();
		Map<Integer, List<MWindowAccess_BH>> windowAccessListsByWindow =
				windowAccessList.stream().collect(Collectors.groupingBy(MWindowAccess_BH::getAD_Window_ID));

		Map<String, AccessLevel> windowsAccessLevels = new HashMap<>();
		for (Map.Entry<Integer, List<MWindowAccess_BH>> windowAccess : windowAccessListsByWindow.entrySet()) {
			if (windowsSetForRole.containsKey(windowAccess.getKey())) {
				// create the accessLevel map
				AccessLevel accessLevel = new AccessLevel();
				if (windowAccess.getValue().stream().anyMatch(MWindowAccess_BH::isReadWrite)) {
					accessLevel.setCanWrite(true);
					if (windowAccess.getValue().stream().anyMatch(MWindowAccess_BH::isBH_CanDeactivate)) {
						accessLevel.setCanDeactivate(true);
					}
				}
				windowsAccessLevels.put(windowsSetForRole.get(windowAccess.getKey()).getAD_Window_UU(),
						accessLevel);
			}
		}
		return windowsAccessLevels;
	}
	
	 /**
	   * Get list of included roles UUIDs,
	   * Because master roles not assigned but included in other roles. 
	   * 
	   * @return List<String> of included role uuids
	   */
		
		public static List<String> fetchIncludedRoleUuids(){
			Properties context = Env.getCtx();
			MRole userRole = MRole.get(context, Env.getAD_Role_ID(context));

			List<MRole> allUserRoles = userRole.getIncludedRoles(true);

			return allUserRoles.stream().map(MRole::getAD_Role_UU).collect(Collectors.toList());
		}
}
