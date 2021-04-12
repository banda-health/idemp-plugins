package org.bandahealth.idempiere.rest.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.compiere.model.MRole;
import org.compiere.model.MWindow;
import org.compiere.model.MWindowAccess;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class RoleUtil {

	public RoleUtil() {}
	
	class AccessLevel {
		boolean canWrite = false;
		boolean canDeactivate = false;
	}
	AccessLevel accessLevel = new RoleUtil().new AccessLevel();
	
	MRole usersRole = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));
	Map<Integer, MWindow> windowsInGLByID = new HashMap<>(); //Get from menu method
	List<MWindowAccess_BH> windowAccessList =
			new Query(Env.getCtx(), MWindowAccess.Table_Name, MWindowAccess.COLUMNNAME_AD_Role_ID + "? AND "
					+ MWindowAccess.COLUMNNAME_AD_Window_ID + " IN (?)", null).list();
	Map<String, AccessLevel> access =
			windowAccessList.stream()
					.filter((windowAccess) -> windowsInGLByID.containsKey(windowAccess.getAD_Window_ID()))
					.collect(Collectors.toMap(
							(windowAccess) -> windowsInGLByID.get(windowsInGLByID.get(windowAccess.getAD_Window_ID()))
									.getAD_Window_UU(), (windowAccess) -> {
								
								if (windowAccess.isReadWrite()) {
									accessLevel.canWrite = true;
								}
								if (windowAccess.isBH_CanDeactivate()) {
									accessLevel.canDeactivate = true;
								}
								return accessLevel;
							}));
		

}
