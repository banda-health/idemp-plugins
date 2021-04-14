package org.bandahealth.idempiere.rest.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.bandahealth.idempiere.rest.model.AccessLevel;
import org.compiere.model.MRole;
import org.compiere.model.MWindow;
import org.compiere.model.MWindowAccess;
import org.compiere.model.Query;
import org.compiere.util.Env;

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
		MRole usersRole = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));

		List<MRole> allUsersRoles = usersRole.getIncludedRoles(true);
		allUsersRoles.add(usersRole);
		List<Integer> roleIds = allUsersRoles.stream().map(MRole::getAD_Role_ID).collect(Collectors.toList());

		// Get all the windows assigned to this role
		String roleInClause = QueryUtil.getWhereClauseAndSetParametersForSet(new HashSet<>(roleIds), optionParams);
		String whereClause = MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Role_ID + " IN (" + roleInClause + ") AND "
				+ MRole.Table_Name + "." + MRole.COLUMNNAME_IsMasterRole + "=\'Y\'";

		Query queryWindows = new Query(Env.getCtx(), MWindow.Table_Name, whereClause, null).setParameters(optionParams)
				.addJoinClause(" JOIN " + MWindowAccess_BH.Table_Name + " ON " + MWindow.Table_Name + "."
						+ MWindow.COLUMNNAME_AD_Window_ID + "=" + MWindowAccess_BH.Table_Name + "."
						+ MWindowAccess_BH.COLUMNNAME_AD_Window_ID)
				.addJoinClause(" JOIN " + MRole.Table_Name + " ON " + MWindowAccess_BH.Table_Name + "."
						+ MWindowAccess_BH.COLUMNNAME_AD_Role_ID + " = " + MRole.Table_Name + "."
						+ MRole.COLUMNNAME_AD_Role_ID);
		List<MWindow> results = queryWindows.list();

		final Map<Integer, MWindow> windowsSetForRole = results.stream()
				.collect(Collectors.toMap(MWindow::get_ID, window -> window));

//		// get list of read/write and deactivate window access for each window
		Query queryWindowAccess = new Query(Env.getCtx(), MWindowAccess.Table_Name,
				MWindowAccess_BH.Table_Name + "." + MWindowAccess_BH.COLUMNNAME_AD_Role_ID + " IN (" + roleInClause
						+ ")",
				null).setParameters(optionParams)
						.addJoinClause(" JOIN " + MRole.Table_Name + " ON " + MWindowAccess_BH.Table_Name + "."
								+ MWindowAccess_BH.COLUMNNAME_AD_Role_ID + "=" + MRole.Table_Name + "."
								+ MRole.COLUMNNAME_AD_Role_ID);
		List<MWindowAccess_BH> windowAccessList = queryWindowAccess.list();

		Map<String, AccessLevel> windowsAccessLevels = new HashMap<>();
		for (MWindowAccess_BH windowAccess : windowAccessList) {
			if (windowsSetForRole.keySet().contains(windowAccess.get_Value(0))) {
				// create the accessLevel map
				AccessLevel accessLevel = new AccessLevel();
				if (windowAccess.isReadWrite()) {
					accessLevel.setCanWrite(true);
				}
				if (windowAccess.isBH_CanDeactivate()) {
					accessLevel.setCanDeactivate(true);
				}
				windowsAccessLevels.put(windowsSetForRole.get(windowAccess.getAD_Window_ID()).getAD_Window_UU(),
						accessLevel);
			}
		}
		return windowsAccessLevels;
	}
}
