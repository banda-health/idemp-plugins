package org.bandahealth.bhgo.unitydashboard;

import java.util.List;

import org.adempiere.webui.adwindow.ToolbarCustomButton;
import org.adempiere.webui.component.ToolBarButton;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.adempiere.webui.theme.ThemeManager;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Util;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Box;
import org.zkoss.zul.Vbox;

public class DPBandaGoPanel extends DashboardPanel implements EventListener<Event>{

	/**
	Custom BandaHealth dash-board with links to:
	 -> product info window
	 -> BH Product
	 -> BH BusinessPartner
	 -> BH Inventory
	*/
	
	private static final long serialVersionUID = 1L;
	private CLogger logger = CLogger.getCLogger(DPBandaGoPanel.class);
	private final String DEFAULT_TOOL_ICON = "Server24.png";

	public DPBandaGoPanel() {
		super();
		this.appendChild(createPanel());
	}
	
	public Box createPanel() {
		Vbox vBox = new Vbox();
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

}
