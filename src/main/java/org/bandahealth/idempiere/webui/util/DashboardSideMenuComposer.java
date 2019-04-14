package org.bandahealth.idempiere.webui.util;

import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.webui.component.Tab;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.compiere.util.Env;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

public class DashboardSideMenuComposer extends SelectorComposer<Panel> {

	private static final long serialVersionUID = 1L;

	@Wire
	private Tabs headers;
	@Wire
	private Tabpanels buttonsTabPanels;
	private DashboardSideMenuDataService menuDataService;
	
	int userId = Env.getContextAsInt(Env.getCtx(), "#AD_User_ID");
	int roleId = Env.getContextAsInt(Env.getCtx(), "#AD_Role_ID");

	@Override
	public void doAfterCompose(Panel panel) {
		try {
			super.doAfterCompose(panel);
			menuDataService = new DashboardSideMenuDataService();
			createMenuHeaders();
			createMenuButtons();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createMenuHeaders() {
		if(RoleAndUserManagement.userRoleHasAllSubRolesIncluded(roleId)) {
			for (MHomeScreenButtonGroup btnGrp : menuDataService.getButtonGroups()) {
				headers.appendChild(new Tab(btnGrp.getName()));
			}
		} else {
			headers.appendChild(new Tab(""));
		}
	}

	public void createMenuButtons() {
		List<MHomeScreenButtonGroup> buttonGroups = menuDataService.getButtonGroups();
		List<MHomeScreenButton> buttons = menuDataService.getButtons();
		for (MHomeScreenButtonGroup buttonGroup : buttonGroups) {
			Tabpanel currentGroupPanel = new Tabpanel();
			List<MHomeScreenButton> buttonsInGroup = buttons.stream()
			        .filter(b -> b.getBH_HmScrn_ButtonGroup_ID() == buttonGroup.getBH_HmScrn_ButtonGroup_ID())
			        .collect(Collectors.toList());
			for (MHomeScreenButton mHomeScreenButton : buttonsInGroup) {
				Grid grid = new DashboardMenuButtonCreation().createButton(mHomeScreenButton);
				currentGroupPanel.appendChild(grid);
			}
			buttonsTabPanels.appendChild(currentGroupPanel);
		}
	}
}
