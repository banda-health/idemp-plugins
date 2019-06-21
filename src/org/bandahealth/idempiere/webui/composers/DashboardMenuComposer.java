package org.bandahealth.idempiere.webui.composers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.adempiere.webui.component.Tab;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.webui.DashboardMenuButtonCreation;
import org.bandahealth.idempiere.webui.RoleAndUserManagement;
import org.bandahealth.idempiere.webui.dataservice.impl.MHomeScreenButtonDataServiceImpl;
import org.bandahealth.idempiere.webui.dataservice.impl.MHomeScreenButtonGroupDataServiceImpl;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;
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
		if (isAdmin) {
			// create a tabpanel for each button group
			for (MHomeScreenButtonGroup buttonGroup : buttonGroups) {
				Tabpanel currentGroupPanel = new Tabpanel();
				buttons.stream()
				        .filter(b -> b.getBH_HmScrn_ButtonGroup_ID() == buttonGroup.getBH_HmScrn_ButtonGroup_ID())
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
			List<MRoleIncluded> assignedSubRoles = new Query(Env.getCtx(), MRoleIncluded.Table_Name,
					MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + roleId, null).addJoinClause(
							" JOIN " + MHomeScreenButton.Table_Name + " ON " + MRoleIncluded.Table_Name + "." +MRoleIncluded.COLUMNNAME_Included_Role_ID
									+ "=" + MHomeScreenButton.Table_Name + "." + MHomeScreenButton.COLUMNNAME_Included_Role_ID)
							.list();
			List<MHomeScreenButton> filteredButtons = new ArrayList<MHomeScreenButton>(); 
			for (MRoleIncluded role : assignedSubRoles) {
				for (MHomeScreenButton mHomeScreenButton : buttons) {
					if(role.getIncluded_Role_ID() == mHomeScreenButton.getIncludedRole_ID()) {
						filteredButtons.add(mHomeScreenButton);
					}
						
				}
			}
			Collections.sort(filteredButtons, new Comparator<MHomeScreenButton>() {
				
				@Override
				public int compare(MHomeScreenButton button1, MHomeScreenButton button2) {
					int btn1IncludedRoleId = button1.getIncludedRole_ID();
					int btn2IncludedRoledId = button2.getIncludedRole_ID();
					if(btn1IncludedRoleId > 0 && btn2IncludedRoledId > 0) {
						MRoleIncluded btn1SubRole = new Query(Env.getCtx(), MRoleIncluded.Table_Name,
								MRoleIncluded.COLUMNNAME_Included_Role_ID + "=" + btn1IncludedRoleId + " AND " + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + roleId, null).first();
						MRoleIncluded btn2SubRole = new Query(Env.getCtx(), MRoleIncluded.Table_Name,
								MRoleIncluded.COLUMNNAME_Included_Role_ID + "=" + btn2IncludedRoledId + " AND " + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + roleId, null).first();
						if(btn1SubRole != null && btn2SubRole != null) {
							return btn1SubRole.getSeqNo() < btn2SubRole.getSeqNo() ? -1
									: btn1SubRole.getSeqNo() > btn2SubRole.getSeqNo() ? 1 : 0;
						} else {
							return 0;
						}
					} else {
						return 0;
					}
				}
			});
			filteredButtons.stream().collect(Collectors.toList()).forEach(button -> {
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
