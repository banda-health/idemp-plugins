package org.bandahealth.idempiere.webui.composers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.webui.component.Tab;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.webui.DashboardMenuButtonCreation;
import org.bandahealth.idempiere.webui.dataservice.impl.MHomeScreenButtonDataServiceImpl;
import org.bandahealth.idempiere.webui.dataservice.impl.MHomeScreenButtonGroupDataServiceImpl;
import org.bandahealth.idempiere.webui.util.RoleAndUserManagement;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Script;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

public class DashboardMenuComposer extends SelectorComposer<Vlayout> {

	private static final long serialVersionUID = 1L;

	@Wire
	private Tabs headers;
	@Wire
	private Tabpanels buttonsTabPanels;
	@Wire
	private Panel mainDashboardPanel;
	private MHomeScreenButtonDataServiceImpl buttonDataService;
	private MHomeScreenButtonGroupDataServiceImpl buttonGroupDataService;

	private Integer userId = Env.getContextAsInt(Env.getCtx(), "#AD_User_ID");
	private Integer roleId = Env.getContextAsInt(Env.getCtx(), "#AD_Role_ID");

	@Override
	public void doAfterCompose(Vlayout vlayout) {
		try {
			super.doAfterCompose(vlayout);
		} catch (Exception e) {
			CLogger.get().severe("An error occured while creating component: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		buttonDataService = new MHomeScreenButtonDataServiceImpl();
		buttonGroupDataService = new MHomeScreenButtonGroupDataServiceImpl();
		createMenuHeaders();
		createMenuButtons(userRoleIsAdmin());
		mainDashboardPanel.query("#panelLayout")
		        .appendChild(new Script(RoleAndUserManagement.appendRoleScriptString()));
		addPendingBillsWidget();
	}

	public void createMenuHeaders() {
		if (userRoleIsAdmin()) {
			for (MHomeScreenButtonGroup btnGrp : buttonGroupDataService.getData()) {
				headers.appendChild(new Tab(btnGrp.getName()));
			}
		} else {
			headers.appendChild(new Tab(Env.getContext(Env.getCtx(), "#AD_Client_Name")));
		}
	}

	public void createMenuButtons(boolean isAdmin) {
		List<MHomeScreenButtonGroup> buttonGroups = buttonGroupDataService.getData();
		List<MHomeScreenButton> buttons = buttonDataService.getData();
		if(isAdmin) {
			//create a tabpanel for each  button group
			for (MHomeScreenButtonGroup buttonGroup : buttonGroups) {
				Tabpanel currentGroupPanel = new Tabpanel();
				buttons.stream().filter(b -> b.getBH_HmScrn_ButtonGroup_ID() == buttonGroup.getBH_HmScrn_ButtonGroup_ID())
				.collect(Collectors.toList()).forEach(button -> {
					Integer buttonRoleId = button.get_ValueAsInt(MHomeScreenButton.COLUMNNAME_Included_Role_ID);
					if ((!userRoleIsAdmin()
							&& RoleAndUserManagement.userRoleHasSpecificSubRoles(roleId, userId, buttonRoleId))
							|| userRoleIsAdmin()) {
						Grid grid = new DashboardMenuButtonCreation().createButton(button);
						currentGroupPanel.appendChild(grid);
					}
				});
				buttonsTabPanels.appendChild(currentGroupPanel);
			}
		} else {
			// use a single tab panel
			Tabpanel currentGroupPanel = new Tabpanel();

			Collections.sort(buttons, new Comparator<MHomeScreenButton>() {

				@Override
				public int compare(MHomeScreenButton button1, MHomeScreenButton button2) {
					return button1.getIncludedRole_ID() < button2.getIncludedRole_ID() ? -1
					        : button1.getIncludedRole_ID() > button2.getIncludedRole_ID() ? 1 : 0;
				}
			});
			buttons.stream()
			.collect(Collectors.toList()).forEach(button -> {
				Integer buttonRoleId = button.get_ValueAsInt(MHomeScreenButton.COLUMNNAME_Included_Role_ID);
				if ((!userRoleIsAdmin()
						&& RoleAndUserManagement.userRoleHasSpecificSubRoles(roleId, userId, buttonRoleId))
						|| userRoleIsAdmin()) {
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

	private void addPendingBillsWidget() {
		Window window = (Window) Executions.createComponents("/zul/PendingBillsWidget.zul", null, null);
		this.getSelf().appendChild(window);
	}
}
