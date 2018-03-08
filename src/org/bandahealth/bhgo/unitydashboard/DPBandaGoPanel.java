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

	public DPBandaGoPanel() {
		super();
		System.out.println("Inside constructor for custom dashboard");
		this.setHeight("300px");
		this.appendChild(createPanel());
		
	}
	
	public Box createPanel() {
		System.out.println("Inside createPanel()");
		Vbox vBox = new Vbox();
		MInfoWindow win = getProductInfoView();
		
		ToolBarButton btnViewItem = new ToolBarButton(win.getName());
		btnViewItem.setSclass("link");
		btnViewItem.setLabel(win.get_Translation("Name"));
		btnViewItem.setImage(ThemeManager.getThemeResource("images/" + (Util.isEmpty(win.getImageURL()) ? "Server24.png" : "Server24.png")));
		btnViewItem.addEventListener(Events.ON_CLICK, this);
		vBox.appendChild(btnViewItem);
		System.out.println("Added product info link to panel");
		
		List<MWindow> bhCustomWindows = getBHCustomWindows();
		for (MWindow mWindow : bhCustomWindows) {
			int count = 0;
			ToolBarButton winBtn = new ToolBarButton(mWindow.getName());
			winBtn.setSclass("link");
			winBtn.setLabel(mWindow.get_Translation("Name"));
			winBtn.setImage(ThemeManager.getThemeResource("images/" + (Util.isEmpty(win.getImageURL()) ? "Info16.png" :"Server24.png")));
			winBtn.addEventListener(Events.ON_CLICK, this);
			System.out.println("Window link "+count+"  added");
			vBox.appendChild(winBtn);
			count++;
		}
		return vBox;
	}
	
	
	
	/*
	 * Get listing of dashboard views and filter only 
	 * the product info view
	 */
	private MInfoWindow getProductInfoView() {
		
		MInfoWindow  productInfoWin = null;
		
		List<MInfoWindow> list = new Query(Env.getCtx(), MInfoWindow.Table_Name, "IsValid='Y' AND IsShowInDashboard='Y'", null)
				.setOnlyActiveRecords(true)
				.setOrderBy(MInfoWindow.COLUMNNAME_SeqNo)
				.list();
		
		for (MInfoWindow currentWindow : list) {
			if (currentWindow.getName().contains("Product Info")) {
				productInfoWin = currentWindow;
			}
		}
		return productInfoWin;
	}
	
	/* Get all custom BH windows 
	 * Assumes every custom table needed is prefixed with BH
	 * 
	 */
	private List<MWindow> getBHCustomWindows(){
		List<MWindow> list = new Query(Env.getCtx(), MWindow.Table_Name, "name like 'BH_%'", null)
				.setOnlyActiveRecords(true)
				.list();
		return list;
	}
	
	
	@Override
	public void onEvent(Event event) throws Exception {
		logger.info(event.toString());
		Component component = event.getTarget();
		String eventName = event.getName();
		int displayId = -1;
		if(eventName.equals(Events.ON_CLICK)) {
			ToolBarButton button = (ToolBarButton) component;
			String windowName = button.getName();
			
			System.out.println("Display ID = " + displayId);
			if(windowName.equals("Product Info")) {
				displayId = getWindowId(windowName,MInfoWindow.Table_Name);
				SessionManager.getAppDesktop().openInfo(displayId);
			}else {
				displayId = getWindowId(windowName,MWindow.Table_Name);
				SessionManager.getAppDesktop().openWindow(displayId, null);
			}
			
		}
	}
	
	/*Get the ID of the window to be displayed*/
	private int getWindowId(String windowName, String windowType) {
		int windowToDisplay = new Query(Env.getCtx(), windowType, "Name = ?", null)
				.setParameters(windowName)
				.setOnlyActiveRecords(true)
				.firstIdOnly();
		return windowToDisplay;
	}

}
