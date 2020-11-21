package org.bandahealth.idempiere.webui.composers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.adempiere.webui.component.Tab;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroup;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.base.model.MUIButton;
import org.bandahealth.idempiere.webui.DashboardMenuButtonCreation;
import org.bandahealth.idempiere.webui.RoleAndUserManagement;
import org.bandahealth.idempiere.webui.dataservice.impl.MDashboardButtonGroupButtonDataServiceImpl;
import org.bandahealth.idempiere.webui.dataservice.impl.MDashboardButtonGroupDataServiceImpl;
import org.compiere.model.MMessage;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.UiException;
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
	private final String logoutMessageUuid = "ee7433c3-ffe0-4ceb-8077-79edf6d36400";
	@Wire
	private Tabs headers;
	@Wire
	private Tabpanels buttonsTabPanels;
	@Wire
	private Panel mainDashboardPanel;
	private MDashboardButtonGroupButtonDataServiceImpl buttonDataService;
	private MDashboardButtonGroupDataServiceImpl buttonGroupDataService;
	private Integer userId = Env.getContextAsInt(Env.getCtx(), "#AD_User_ID");
	private Integer roleId = Env.getContextAsInt(Env.getCtx(), "#AD_Role_ID");
	private String usersLanguage = Env.getContext(Env.getCtx(), "#AD_Language");

	@Override
	public void doAfterCompose(Vlayout vlayout) {
		try {
			super.doAfterCompose(vlayout);
		} catch (Exception e) {
			CLogger.get().severe("An error occured while creating component: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		buttonDataService = new MDashboardButtonGroupButtonDataServiceImpl();
		buttonGroupDataService = new MDashboardButtonGroupDataServiceImpl();
		createMenuHeaders();
		createMenuButtons();
		mainDashboardPanel.query("#panelLayout")
				.appendChild(new Script(RoleAndUserManagement.appendRoleScriptString()));
		appendUIButtonTranslations();
		addPendingBillsWidget();
	}

	public void createMenuHeaders() {
		if (userRoleIsAdmin()) {
			for (MDashboardButtonGroup btnGrp : buttonGroupDataService.getData()) {
				headers.appendChild(new Tab(btnGrp.get_Translation(MDashboardButtonGroup.COLUMNNAME_Name, usersLanguage)));
			}
		} else {
			headers.appendChild(new Tab(Env.getContext(Env.getCtx(), "#AD_Client_Name")));
		}
	}

	public void createMenuButtons() {
		List<MDashboardButtonGroup> buttonGroups = buttonGroupDataService.getData();
		List<MDashboardButtonGroupButton> buttons = buttonDataService.getData();
		Tabpanel currentGroupPanel = null;
		if (userRoleIsAdmin()) {
			// create a tabpanel for each button group
			for (MDashboardButtonGroup buttonGroup : buttonGroups) {
				currentGroupPanel = addButtonsToPanel(buttons, buttonGroup);
				buttonsTabPanels.appendChild(currentGroupPanel);
			}
		} else {
			// use a single tab panel
			List<MDashboardButtonGroupButton> menuButtonsInRole = filterMenuButtonsAssignedForRole(buttons, roleId);
			Collections.sort(menuButtonsInRole, new Comparator<MDashboardButtonGroupButton>() {

				@Override
				public int compare(MDashboardButtonGroupButton button1, MDashboardButtonGroupButton button2) {
					int btn1IncludedRoleId = button1.getIncludedRole_ID();
					int btn2IncludedRoledId = button2.getIncludedRole_ID();
					if (btn1IncludedRoleId > 0 && btn2IncludedRoledId > 0) {
						MRoleIncluded btn1SubRole = new Query(Env.getCtx(), MRoleIncluded.Table_Name,
								MRoleIncluded.COLUMNNAME_Included_Role_ID + "=" + btn1IncludedRoleId + " AND "
										+ MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + roleId,
								null).first();
						MRoleIncluded btn2SubRole = new Query(Env.getCtx(), MRoleIncluded.Table_Name,
								MRoleIncluded.COLUMNNAME_Included_Role_ID + "=" + btn2IncludedRoledId + " AND "
										+ MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + roleId,
								null).first();
						if (btn1SubRole != null && btn2SubRole != null) {
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
			currentGroupPanel = addButtonsToPanel(menuButtonsInRole, null);
			buttonsTabPanels.appendChild(currentGroupPanel);
		}
	}

	private boolean userRoleIsAdmin() {
		return RoleAndUserManagement.checkRoleHasAllSubRolesIncluded(roleId);
	}

	private List<MDashboardButtonGroupButton> filterMenuButtonsAssignedForRole(List<MDashboardButtonGroupButton> buttons,
			Integer currentRoleId) {
		List<MDashboardButtonGroupButton> filteredButtons = new ArrayList<MDashboardButtonGroupButton>();
		List<MRoleIncluded> assignedSubRoles = new Query(Env.getCtx(), MRoleIncluded.Table_Name,
				MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + currentRoleId, null)
				.addJoinClause(" JOIN " + MDashboardButtonGroupButton.Table_Name + " ON " + MRoleIncluded.Table_Name + "."
						+ MRoleIncluded.COLUMNNAME_Included_Role_ID + "=" + MDashboardButtonGroupButton.Table_Name + "."
						+ MDashboardButtonGroupButton.COLUMNNAME_Included_Role_ID)
				.list();
		for (MRoleIncluded role : assignedSubRoles) {
			for (MDashboardButtonGroupButton mHomeScreenButton : buttons) {
				if (role.getIncluded_Role_ID() == mHomeScreenButton.getIncludedRole_ID()) {
					filteredButtons.add(mHomeScreenButton);
				}
			}
		}
		return filteredButtons;
	}

	private Tabpanel addButtonsToPanel(List<MDashboardButtonGroupButton> buttons, MDashboardButtonGroup group) {
		Tabpanel panel = new Tabpanel();
		Stream<MDashboardButtonGroupButton> buttonsStream = buttons.stream();
		if (group != null) {
			buttonsStream = buttonsStream.filter(b -> b.getBH_DbrdBtnGrp_ID() == group.getBH_DbrdBtnGrp_ID());
		}
		buttonsStream.collect(Collectors.toList()).forEach(button -> {
			try {
				Integer buttonRoleId = button.getIncludedRole_ID();
				if ((!userRoleIsAdmin() && RoleAndUserManagement.userRoleHasSpecificSubRoles(roleId, userId, buttonRoleId))
						|| userRoleIsAdmin()) {
					Grid grid = new DashboardMenuButtonCreation().createButton(button, usersLanguage);
					panel.appendChild(grid);
				}
			} catch (UiException exception) {
				//Non-unique IDs found for components
			}
		});

		return panel;
	}

	private void addPendingBillsWidget() {
		Window window = (Window) Executions.createComponents("/zul/PendingBillsWidget.zul", null, null);
		this.getSelf().appendChild(window);
	}

	/**
	 * This method puts the translations of the UI buttons into a JSON structure for the JS files to read
	 * Structure:
	 * {
	 *     buttonTranslations: [{
	 *         name: ''
	 *         cssVariableName: ''
	 *     }, ...],
	 *     logout: {
	 *         translation: '',
	 *         helpTip: ''
	 *     }
	 * }
	 */
	private void appendUIButtonTranslations() {
		List<MUIButton> uiButtons = new Query(Env.getCtx(), MUIButton.Table_Name, null, null)
				.setOnlyActiveRecords(true)
				.list();
		StringBuilder translationJSFileContent = new StringBuilder();
		// Initialize the script call and translation object
		translationJSFileContent.append("require(['config/translation'], function (translation) { translation.update({ ");
		// Add the button translations
		translationJSFileContent.append("buttonTranslations: [");
		for (MUIButton uiButton : uiButtons) {
			translationJSFileContent.append("{ name: '");
			translationJSFileContent.append(uiButton.get_Translation(MUIButton.COLUMNNAME_Name, usersLanguage));
			translationJSFileContent.append("', cssVariableName: '");
			translationJSFileContent.append(uiButton.getCssVariableName());
			translationJSFileContent.append("' },");
		}
		translationJSFileContent.append("], ");
		// Add the logout translation
		String whereClause = MMessage.COLUMNNAME_AD_Message_UU + " = '" + logoutMessageUuid + "'";
		MMessage logoutMessage = new Query(Env.getCtx(), MMessage.Table_Name, whereClause, null)
				.first();
		translationJSFileContent.append("logout: { translation: '");
		translationJSFileContent.append(logoutMessage.get_Translation(MMessage.COLUMNNAME_MsgText, usersLanguage));
		translationJSFileContent.append("', helpTip: '");
		translationJSFileContent.append(logoutMessage.get_Translation(MMessage.COLUMNNAME_MsgTip, usersLanguage));
		translationJSFileContent.append("' }");
		// Close the translation update call and require call
		translationJSFileContent.append(" }); });");
		// Add the script to be run
		mainDashboardPanel.query("#panelLayout").appendChild(new Script(translationJSFileContent.toString()));
	}
}
