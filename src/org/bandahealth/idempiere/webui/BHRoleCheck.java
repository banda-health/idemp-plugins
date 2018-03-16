package org.bandahealth.idempiere.webui;

import java.util.Properties;

import org.compiere.model.I_AD_Menu;
import org.compiere.model.I_AD_User_Roles;
import org.compiere.model.MRole;
import org.compiere.model.MRoleOrgAccess;
import org.compiere.model.MUserRoles;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

/**
 * 
 * @author kelly
 * Configure visibility of search and tree menu based on the role selected by the user
 * 
 */
public class BHRoleCheck {

	private static final long serialVersionUID = -8882317361519082007L;
	private static int roleId;
	private static int userId;
	private static int clientId;
	private static Properties context;
	private static CLogger logger;
	private static MUserRoles userRoles;

	static {
		
		context = Env.getCtx();
		BHRoleCheck(context,Env.getAD_User_ID(context), Env.getAD_Role_ID(context),null);
	}
	
	public static void getAllRolesForUser() {
		MUserRoles[] userRoles = MUserRoles.getOfUser(context, getUserId());
		for (int i = 0; i < userRoles.length; i++) {
			logger.info(userRoles[i].toString());
		}
	}
	
	private static void BHRoleCheck(Properties context2, int ad_User_ID, int ad_Role_ID, String object) {
		userRoles = new MUserRoles(context2, ad_User_ID, ad_Role_ID, object);
	}

	private static int getRoleId() {
		roleId = Env.getAD_Role_ID(context);
		logger.info("Role ID: "+roleId);
		return roleId;
	}
	
	private static int getUserId() {
		userId = Env.getAD_User_ID(context);
		logger.info("User ID: "+userId);
		return userId;
	}
}
