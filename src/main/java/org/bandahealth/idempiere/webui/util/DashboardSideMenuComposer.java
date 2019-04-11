package org.bandahealth.idempiere.webui.util;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.webui.component.Tab;
import org.adempiere.webui.component.Tabpanel;
import org.adempiere.webui.component.Tabs;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Panel;

public class DashboardSideMenuComposer extends SelectorComposer<Panel>{

	private static final long serialVersionUID = 1L;
	
	@Wire("#dboard_menu_tabs")
	private Tabs tabs;
	@Wire("#dboard_menu_tabpanels")
	private Tabpanel tabpanel;
	private DashboardSideMenuDataPopulator dashboardMenuPopulator;
	
	@Override
	public void doAfterCompose(Panel panel) {
		try {
			super.doAfterCompose(panel);
			dashboardMenuPopulator = new DashboardSideMenuDataPopulator();
			tabs = new Tabs();
			tabpanel = new Tabpanel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Tab> tabChildren = createTabs();
		for (Tab tab : tabChildren) {
			tabs.appendChild(tab);
		}
	}
	
	public List<Tab> createTabs(){
		List<Tab> tabs = new ArrayList<Tab>();
		for (MHomeScreenButtonGroup  btnGrp : dashboardMenuPopulator.getButtonGroups()) {
			Tab tab = new Tab(btnGrp.getName());
			tabs.add(tab);
		}
		return tabs;
	}
	
	public List<Tabpanel> createTabPanelButtons(Integer buttonGroupId){
		List<Tabpanel> tabPanels = new ArrayList<Tabpanel>();
		for (MHomeScreenButton button : dashboardMenuPopulator.getButtonsInButtonGroup(buttonGroupId)) {
			UIUtil.createButton(button);
		}
		return tabPanels;
	}


	


}
