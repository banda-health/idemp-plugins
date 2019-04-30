package org.bandahealth.idempiere.webui.composers;

import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.webui.component.Tab;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.webui.DashboardMenuButtonCreation;
import org.bandahealth.idempiere.webui.DashboardMenuDataService;
import org.bandahealth.idempiere.webui.util.RoleAndUserManagement;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Script;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

public class DashboardMenuComposer extends SelectorComposer<Panel> {

	private static final long serialVersionUID = 1L;

	@Wire
	private Tabs headers;
	@Wire
	private Tabpanels buttonsTabPanels;
	@Wire
	private Panel mainDashboardPanel;
	private DashboardMenuDataService menuDataService;
	
	private Integer userId = Env.getContextAsInt(Env.getCtx(), "#AD_User_ID");
	private Integer roleId = Env.getContextAsInt(Env.getCtx(), "#AD_Role_ID");

	@Override
	public void doAfterCompose(Panel panel) {
		try {
			super.doAfterCompose(panel);
		} catch (Exception e) {
			CLogger.get().severe("An error occured while creating component: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
			menuDataService = new DashboardMenuDataService();
			createMenuHeaders();
			createMenuButtons();
			mainDashboardPanel.query("#panelLayout").appendChild(new Script(RoleAndUserManagement.appendRoleScriptString()));
	}

	public void createMenuHeaders() {
		if(userRoleIsAdmin()) {
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
			buttons.stream()
			        .filter(b -> b.getBH_HmScrn_ButtonGroup_ID() == buttonGroup.getBH_HmScrn_ButtonGroup_ID())
			        .collect(Collectors.toList())
			        .forEach(button->{
			        	Integer buttonRoleId = button.get_ValueAsInt(MHomeScreenButton.COLUMNNAME_Included_Role_ID);
						if ((!userRoleIsAdmin() && RoleAndUserManagement.userRoleHasSpecificSubRoles(roleId, userId, buttonRoleId)) || userRoleIsAdmin()) {
							Grid grid = new DashboardMenuButtonCreation().createButton(button);
							currentGroupPanel.appendChild(grid);
						}
			        });
			buttonsTabPanels.appendChild(currentGroupPanel);
		}
	}
	
	private boolean userRoleIsAdmin() {
		return RoleAndUserManagement.checkRoleHasAllSubRolesIncluded(roleId);
	}
}
