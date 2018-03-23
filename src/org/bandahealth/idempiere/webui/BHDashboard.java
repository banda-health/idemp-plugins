package org.bandahealth.idempiere.webui;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.adempiere.webui.IWebClient;
import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.component.ToolBarButton;
import org.adempiere.webui.dashboard.DPActivities;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.desktop.DashboardController;
import org.adempiere.webui.desktop.IDesktop;
import org.adempiere.webui.session.SessionManager;
import org.adempiere.webui.theme.ThemeManager;
import org.compiere.model.I_AD_Role;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MDashboardContentAccess;
import org.compiere.model.MDashboardPreference;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MRole;
import org.compiere.model.MUserRoles;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Util;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.ext.Scope;
import org.zkoss.zk.ui.metainfo.ComponentDefinition;
import org.zkoss.zk.ui.metainfo.ComponentDefinitionMap;
import org.zkoss.zk.ui.metainfo.NodeInfo;
import org.zkoss.zk.ui.metainfo.PageDefinition;
import org.zkoss.zul.Anchorchildren;
import org.zkoss.zul.Box;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;

public class BHDashboard extends DashboardPanel implements EventListener<Event>{

	/**
	Custom BandaHealth dash-board with links to:
	 -> product info window
	 -> BH Product
	 -> BH BusinessPartner
	 -> BH Inventory
	*/
	
	private static final long serialVersionUID = 1L;
	private CLogger logger = CLogger.getCLogger(BHDashboard.class);
	
	private int clientId;
	private int userId;
	private int roleId;
	
	private final String DEFAULT_TOOL_ICON = "Server24.png";
	private final String ORG_ONLY_ACESS = "O";
    private Properties context;
    private Desktop desktop;
    
	public BHDashboard() {
		super();
		context = Env.getCtx();
		clientId = Env.getAD_Client_ID(context);
		userId = Env.getAD_User_ID(context);
		roleId = Env.getAD_Role_ID(context);
		new BHCustomSelect().getDashboards();
		this.appendChild(createPanel());
	}
	
	public Box createPanel() {
		Vbox vBox = new Vbox();
		vBox.setClientAttribute("style", "font-size:14px;");
		MInfoWindow productInfoWindow = filterFromViews("Product Info");
			if(productInfoWindow != null) {
				ToolBarButton button = createPanelButton(productInfoWindow.getName(),
						"link",
						productInfoWindow.get_Translation("Name"),
						productInfoWindow.getImageURL());
				button.addEventListener(Events.ON_CLICK, this);
				vBox.appendChild(button);
				}
			//add links to BH custom windows
			List<MWindow> bhCustomWindows = getBHCustomWindows();
			for (MWindow mWindow : bhCustomWindows) {
				ToolBarButton winBtn = createPanelButton(mWindow.getName(),
						"link",
						mWindow.getName(),
						DEFAULT_TOOL_ICON);
				winBtn.addEventListener(Events.ON_CLICK, this);
				vBox.appendChild(winBtn);
			}
		
		return vBox;
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		String eventName = event.getName();
		int displayId = -1;
		if(eventName.equals(Events.ON_CLICK)) {
			ToolBarButton button = (ToolBarButton) component;
			String windowName = button.getName();
			if(windowName.equals("Product Info")) {
				displayId = getWindowId(windowName,MInfoWindow.Table_Name);
				SessionManager.getAppDesktop().openInfo(displayId);
			}else {
				displayId = getWindowId(windowName,MWindow.Table_Name);
				SessionManager.getAppDesktop().openWindow(displayId, null);
			}
			
		}
	}
	
	/*
	 * Get listing of dashboard views and filter only 
	 * the product info view
	 */
	private MInfoWindow filterFromViews(String viewName) {
		MInfoWindow  productInfoWin = null;
		List<MInfoWindow> list = new Query(
				Env.getCtx(), 
				MInfoWindow.Table_Name, 
				"IsValid='Y' AND IsShowInDashboard='Y'",
				null).setOnlyActiveRecords(true).list();
		for (MInfoWindow currentWindow : list) {
			if (currentWindow.getName().contains(viewName)) {
				productInfoWin = currentWindow;
			}
		}
		return productInfoWin;
	}
	
	/* Get all custom BH windows 
	 * Assumes every custom table needed is prefixed with BH
	 */
	private List<MWindow> getBHCustomWindows(){
		List<MWindow> list = new Query(Env.getCtx(), 
				MWindow.Table_Name, 
				"name like 'BH_%'", 
				null)
				.setOnlyActiveRecords(true)
				.list();
		return list;
	}
	
	/*
	 * Get the ID of the window to be displayed
	 */
	private int getWindowId(String windowName, String windowType) {
		int windowToDisplay = new Query(Env.getCtx(), 
				windowType, 
				"Name = ?",
				null).setParameters(windowName).setOnlyActiveRecords(true).firstIdOnly();
		return windowToDisplay;
	}
	
	/*Create toolbar buttons for the panel*/
	private ToolBarButton createPanelButton(String name, String styleClass, String label, String image) {
		ToolBarButton itemLink = new ToolBarButton(name);
		itemLink.setSclass(styleClass);
		itemLink.setLabel(label);
		itemLink.setImage(
				ThemeManager.getThemeResource("images/" + 
						(Util.isEmpty(image) ? image : DEFAULT_TOOL_ICON)));
		return itemLink;
	}

	
	public boolean isOrgAccessLevel() {
		boolean isOrgAccess = false;
		//get user roles associated with this user
		MUserRoles[] roles = MUserRoles.getOfUser(context, Env.getAD_User_ID(context));
		for (MUserRoles mUserRole : roles) {
			//get roleId
			int roleId = mUserRole.getAD_Role_ID();
			//query db table (ad_role) and get user level of this role
			String whereClause = I_AD_Role.COLUMNNAME_AD_Role_ID+"=?";
			MRole role = new Query(context,I_AD_Role.Table_Name,whereClause, null)
					.setParameters(roleId)
					.first();
			//if has org access only, customize dashboard
			logger.info("[BEBUG]"+role.get_ValueAsString("userlevel"));
			if(role.get_ValueAsString("userlevel").equals(ORG_ONLY_ACESS)) {
				logger.info("[DEBUG] has org only accesslevel");
				isOrgAccess = true;
			}
		}
		return isOrgAccess;
	}
}
