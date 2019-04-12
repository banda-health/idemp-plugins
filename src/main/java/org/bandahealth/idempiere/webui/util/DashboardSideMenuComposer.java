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
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Panel;

public class DashboardSideMenuComposer extends SelectorComposer<Panel> {

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		panel.setAttribute("btnGroupsModel", getMenuGroupTabs());
//		panel.setAttribute("btnItemsModel", getMenuButtonsTabPanels());
	}

	public ListModelList<Tab> getMenuGroupTabs() {
		ListModelList<Tab> tabModel = new ListModelList<>();
		for (MHomeScreenButtonGroup btnGrp : dashboardMenuPopulator.getButtonGroups()) {
			Tab tab = new Tab(btnGrp.getName());
			tabModel.add(tab);
		}
		return tabModel;
	}

	public List<Tabpanel> createTabPanelButtons(Integer buttonGroupId) {
		List<Tabpanel> tabPanels = new ArrayList<Tabpanel>();
		for (MHomeScreenButton button : dashboardMenuPopulator.getButtonsInButtonGroup(buttonGroupId)) {
			UIUtil.createButton(button);
		}
		return tabPanels;
	}

}
