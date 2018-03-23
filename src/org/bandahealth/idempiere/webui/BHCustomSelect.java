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
		for (Component component : desktopComponents) {
			if(component.getId().equals("desktop_tabbox")) {
				Collection<Component> fellows = component.getFellows();
				System.out.println("Fellows in "+component.getId()+": "+fellows.size());
				for (Component fellow : fellows) {
					System.out.println(fellow+": Attributes count: "+fellow.getAttributes().size());
					if(fellow.getWidgetClass().equals("zul.tab.Tabbox")) {
						System.out.print("\tWidgetClass: "+fellow.getWidgetClass()+"\n");
						for (Component item : fellow.getChildren()) {
							if(item.getWidgetClass().equals("zul.tab.Tabpanels")) {
								if(item.getChildren().size() > 0) {
									
									for (Component tabpanelChildren : item.getChildren()) {
										System.out.println("Class "+tabpanelChildren.getWidgetClass());
//										System.out.println("kids in tab panel: "+tabpanelChildren.getFirstChild().getFirstChild().
//												getFirstChild().getFirstChild().getChildren());
									}
								}else {
									System.out.println("has no kids!");
								}
							}
						}
					}
				}
			}
		}
	}
	}

