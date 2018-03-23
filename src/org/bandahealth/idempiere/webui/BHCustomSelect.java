package org.bandahealth.idempiere.webui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.desktop.DashboardController;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MDashboardContentAccess;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Script;

public class BHCustomSelect extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2436572134941636762L;

	private DashboardPanel panel;
	private static CLogger logger = CLogger.getCLogger(BHCustomSelect.class);
	private int clientId;
	private int userId;
	private int roleId;
	private Properties context;
	
	
	public BHCustomSelect() {
		context = Env.getCtx();
		clientId = Env.getAD_Client_ID(context);
		roleId = Env.getAD_Role_ID(context);
		userId = Env.getAD_User_ID(context);
		}
	
	public void getDashboards() {
		Desktop desktop = AEnv.getDesktop();
		Collection<Component> desktopComponents = desktop.getComponents();
		String className = Env.getAD_Org_ID(context) >0 ? "organization":clientId > 0 ? "client" : "system";
			Script jsFile = new Script();
			jsFile.setSrc("/theme/bandahealth/js/bandahealth.js");
			Component firstComponent = desktopComponents.iterator().next();
//			firstComponent.
//			firstComponent.appendChild(jsFile);
//			firstComponent.appendChild(new Script("bandahealth.addRoleClass("+className+");"));
	}
	}

