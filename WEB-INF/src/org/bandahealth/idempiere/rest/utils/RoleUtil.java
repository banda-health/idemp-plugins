package org.bandahealth.idempiere.rest.utils;

import java.util.ArrayList;
import java.util.Arrays;
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

		final List<Object> optionParams = new ArrayList<>();
		
		MRole usersRole = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));
		List<MRole> allUsersRoles = usersRole.getIncludedRoles(true);
		allUsersRoles.add(usersRole);
		List<Integer> roleIds = allUsersRoles.stream().map(MRole::getAD_Role_ID).collect(Collectors.toList());
		
		optionParams.add(usersRole.get_ID());
		
		// Get all the windows assigned to this role
		String whereClause = MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Role_ID + "=?";
		String roleInClause = QueryUtil.getWhereClauseAndSetParametersForSet(new HashSet<>(roleIds), optionParams);
		Query query = new Query(Env.getCtx(), MWindow.Table_Name, whereClause + " AND " + MWindowAccess_BH.Table_Name
				+ "." + MWindowAccess_BH.COLUMNNAME_AD_Role_ID + " IN (" + roleInClause + ")", null)
						.setParameters(optionParams);

		query.addJoinClause(" JOIN " + MWindowAccess_BH.Table_Name + " ON " + MWindow.Table_Name + "."
				+ MWindow.COLUMNNAME_AD_Window_ID + "=" + MWindowAccess_BH.Table_Name + "."
				+ MWindowAccess_BH.COLUMNNAME_AD_Window_ID)
				.addJoinClause(" JOIN " + MRole.Table_Name + " ON " + MWindowAccess_BH.Table_Name + "."
						+ MWindowAccess_BH.COLUMNNAME_AD_Role_ID + " = " + MRole.Table_Name + "."
						+ MRole.COLUMNNAME_AD_Role_ID);
		List<MWindow> results = query.list();

		final Map<Integer, MWindow> windowsSetForRole = results.stream()
				.collect(Collectors.toMap(MWindow::get_ID, window -> window));

		// get list of read/write and deactivate window access for each window
		List<MWindowAccess_BH> windowAccessList = new Query(Env.getCtx(), MWindowAccess.Table_Name,
				MWindowAccess.COLUMNNAME_AD_Role_ID + "=? AND " + MWindowAccess.COLUMNNAME_AD_Window_ID + " IN (?)",
				null).setParameters(Arrays.asList(usersRole.get_ID())).list();

		Map<String, AccessLevel> access = windowAccessList.stream()
				.filter((windowAccess) -> windowsSetForRole.containsKey(windowAccess.getAD_Window_ID())).collect(
						Collectors.toMap(
								(windowAccess) -> windowsSetForRole
										.get(windowsSetForRole.get(windowAccess.getAD_Window_ID())).getAD_Window_UU(),
								(windowAccess) -> {
									AccessLevel accessLevel = new AccessLevel();
									if (windowAccess.isReadWrite()) {
										accessLevel.setCanWrite(true);
									}
									if (windowAccess.isBH_CanDeactivate()) {
										accessLevel.setCanDeactivate(true);
									}
									return accessLevel;
								}));

		return access;
	}
}
