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
public class BHRoleCheck extends MUserRoles{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8882317361519082007L;

	public BHRoleCheck(Properties ctx, int AD_User_ID, int AD_Role_ID, String trxName) {
		super(ctx, AD_User_ID, AD_Role_ID, trxName);
	}

	private static int roleId;
	private static int clientId;
	private static Properties context;
	private static CLogger logger;
	
	public static void initalize() {
		context = Env.getCtx();
		logger = CLogger.getCLogger(BHRoleCheck.class);
	}
	
	public static void getAllRoles() {
		MUserRoles[] userRoles = MUserRoles.getOfRole(context, getRoleId());
		for (int i = 0; i < userRoles.length; i++) {
			logger.info(userRoles[i].toString());
		}
		
	}
	
	public static int getRoleId() {
		roleId = Env.getAD_Role_ID(context);
		logger.info("Role ID: "+roleId);
		return roleId;
	}
	
}
