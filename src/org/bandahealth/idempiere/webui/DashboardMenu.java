package org.bandahealth.idempiere.webui;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.component.Column;
import org.adempiere.webui.component.Columns;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.component.Tab;
import org.adempiere.webui.component.Tabbox;
import org.adempiere.webui.component.Tabpanel;
import org.adempiere.webui.component.Tabpanels;
import org.adempiere.webui.component.Tabs;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroup;
import org.bandahealth.idempiere.base.model.MUIButton;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.webui.util.DesktopComposer;
import org.bandahealth.idempiere.webui.util.DraftSaleOrderListRenderer;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.MMessage;
import org.compiere.model.MOrder;
import org.compiere.model.MQuery;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.MUserRoles;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Script;
import org.zkoss.zul.Window;

public class DashboardMenu extends DashboardPanel implements EventListener<Event> {

	private static final long serialVersionUID = 1L;
	private Hlayout layout;
	private Div sideBar;
	private Tabbox tabbox;
	private Tabs tabs;
	private Tabpanels tabpanels;
	private Div widgetArea = new Div();
	private Div contentArea = new Div();
	private List<MOrder> saleOrders;
	private Integer unclosedSOCount = 0;
	private static Integer MAX_RESULTS_SIZE = 20;
	private boolean userHasAllRoles = false;
	private final static String ALL_SUBROLES_INCLUDED = "allRoles";

	int userId = Env.getContextAsInt(Env.getCtx(), "#AD_User_ID");
	int roleId = Env.getContextAsInt(Env.getCtx(), "#AD_Role_ID");
	String usersLanguage = Env.getContext(Env.getCtx(), "#AD_Language");

	String logoutMessageUuid = "ee7433c3-ffe0-4ceb-8077-79edf6d36400";

	public DashboardMenu() {
		super();
		this.setId("bandaDashboard");
		try {
			new DesktopComposer().doAfterCompose(this);
		} catch (Exception e) {
			CLogger.get().severe("BH Error: " + e.toString());
		}
		initLayout();
		assembleComponents();
	}

	private void initLayout() {
		this.setSclass("openmrs bh-dashboard-panel");
		layout = new Hlayout();
		sideBar = new Div();
		tabbox = new Tabbox();
		tabs = new Tabs();
		tabpanels = new Tabpanels();
		widgetArea.setSclass("bh-so-list-window");
		appendUIButtonTranslations();
		appendRoleScript();
	}

	private void assembleComponents() {
		layout.setParent(this);
		tabbox.setMold("accordion");
		userHasAllRoles = hasAllRolesAssigned();
		tabs = createButtonGroupTabs();
		tabpanels = createTabpanels();
		tabs.setParent(tabbox);
		tabpanels.setParent(tabbox);
		sideBar.appendChild(tabbox);
		tabbox.setStyle("margin-bottom:10px;");
		sideBar.appendChild(widgetArea);
		layout.appendChild(sideBar);
		createIncompleteBillsWidget();
	}

	private Tabs createButtonGroupTabs() {
		Tabs tabs = new Tabs();
		if (userHasAllRoles) {
			List<MDashboardButtonGroup> buttonGroups = new Query(Env.getCtx(), MDashboardButtonGroup.Table_Name, null,
			        null).setOnlyActiveRecords(true).setOrderBy(MDashboardButtonGroup.COLUMNNAME_LineNo).list();
			for (MDashboardButtonGroup buttonGroup : buttonGroups) {
				Tab tab = new Tab(buttonGroup.get_Translation(MDashboardButtonGroup.COLUMNNAME_Name, usersLanguage));
				tabs.appendChild(tab);
			}
		} else {
			tabs.appendChild(new Tab("Menu"));
		}
		return tabs;
	}

	private boolean hasAllRolesAssigned() {

		List<MRole> subRolesIncludedInRole = new Query(Env.getCtx(), MRole.Table_Name,
		        MRoleIncluded.Table_Name + "." + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + roleId, null)
		                .addJoinClause("JOIN " + MRoleIncluded.Table_Name + " ON " + MRole.Table_Name + "."
		                        + MRole.COLUMNNAME_AD_Role_ID + "=" + MRoleIncluded.Table_Name + "."
		                        + MRoleIncluded.COLUMNNAME_Included_Role_ID)
		                .list();
		for (MRole subRole : subRolesIncludedInRole) {
			if (subRole.get_ValueAsString(MRole.COLUMNNAME_Name).equalsIgnoreCase(ALL_SUBROLES_INCLUDED)) {
				userHasAllRoles = true;
			}
		}
		return userHasAllRoles;
	}

	private Tabpanels createTabpanels() {
		Tabpanels tabpanelsContainer = new Tabpanels();
		List<MDashboardButtonGroupButton> buttons = new Query(Env.getCtx(), MDashboardButtonGroupButton.Table_Name, null, null)
		        .setOnlyActiveRecords(true).setOrderBy(MDashboardButtonGroupButton.COLUMNNAME_LineNo).list();
		if (userHasAllRoles) {
			// show buttons in group tabs
			List<MDashboardButtonGroup> buttonGroups = new Query(Env.getCtx(), MDashboardButtonGroup.Table_Name, null,
			        null).setOnlyActiveRecords(true).setOrderBy(MDashboardButtonGroup.COLUMNNAME_LineNo).list();

			for (MDashboardButtonGroup buttonGroup : buttonGroups) {
				// get all buttons in that group
				List<MDashboardButtonGroupButton> buttonsInGroup = buttons.stream()
				        .filter(b -> b.getBH_DbrdBtnGrp_ID() == buttonGroup.getBH_DbrdBtnGrp_ID())
				        .collect(Collectors.toList());
				createTabButtons(buttonsInGroup, tabpanelsContainer, userHasAllRoles);
			}
		} else {
			// show buttons in a single tab
			createTabButtons(buttons, tabpanelsContainer, userHasAllRoles);
		}

		return tabpanelsContainer;
	}

	private void createTabButtons(List<MDashboardButtonGroupButton> buttonsInGroup, Tabpanels tabpanelsContainer,
	        boolean userHasAllRoles) {
		Grid buttonGroupGrid = new Grid();
		buttonGroupGrid.setStyle("border:0px");
		Columns columns = new Columns();
		Rows rows = new Rows();
		Column[] col = { new Column() };
		for (int i = 0; i < col.length; i++) {
			col[i].setParent(columns);
		}
		buttonGroupGrid.appendChild(columns);
		buttonGroupGrid.appendChild(rows);

		for (MDashboardButtonGroupButton button : buttonsInGroup) {
			try {
				Integer buttonRoleId = button.get_ValueAsInt(MDashboardButtonGroupButton.COLUMNNAME_Included_Role_ID);
				if ((!userHasAllRoles && userHasSpecificRole(roleId, userId, buttonRoleId)) || userHasAllRoles) {
					// create a grid to hold icon and text
					Row row = new Row();
					Grid btnGrid = UIUtil.createButton(button, usersLanguage);
					row.appendCellChild(btnGrid);
					row.setParent(rows);
					btnGrid.addEventListener(Events.ON_CLICK, this);
				}
			} catch (Exception ex) {
				CLogger.get().severe("BH Error creating button: " + ex.toString());
			}
		}
		Tabpanel panel = new Tabpanel();
		panel.appendChild(buttonGroupGrid);
		tabpanelsContainer.appendChild(panel);

	}

	private boolean userHasSpecificRole(Integer roleId, Integer userId, Integer buttonRoleId) {
		boolean hasRoleAssigned = false;

		List<MRoleIncluded> subRolesIncludedInRole = new Query(Env.getCtx(), MRoleIncluded.Table_Name,
		        MUserRoles.Table_Name + "." + MUserRoles.COLUMNNAME_AD_Role_ID + "=" + roleId + " AND "
		                + MUserRoles.COLUMNNAME_AD_User_ID + "=" + userId,
		        null).addJoinClause(
		                "JOIN " + MRole.Table_Name + " ON " + MRoleIncluded.Table_Name + "."
		                        + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + MRole.Table_Name + "."
		                        + MRole.COLUMNNAME_AD_Role_ID)
		                .addJoinClause("JOIN " + MUserRoles.Table_Name + " ON " + MRoleIncluded.Table_Name + "."
		                        + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=" + MUserRoles.Table_Name + "."
		                        + MUserRoles.COLUMNNAME_AD_Role_ID)
		                .list();

		for (MRoleIncluded subRole : subRolesIncludedInRole) {
			if (buttonRoleId == subRole.get_ValueAsInt(MRoleIncluded.COLUMNNAME_Included_Role_ID)) {
				hasRoleAssigned = true;
			} else {
				continue;
			}
		}
		return hasRoleAssigned;
	}

	private void appendRoleScript() {
		if (isUserViewingAnOrganization()) {
			layout.appendChild(new Script("requirejs(['user/organization'], function () {});"));
		} else if (isUserViewingAClient()) {
			layout.appendChild(new Script("requirejs(['user/client'], function () {});"));
		}
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
		layout.appendChild(new Script(translationJSFileContent.toString()));
	}

	private Boolean isUserViewingAnOrganization() {
		Boolean isViewingAnOrganization = true;
		if (Env.getAD_Org_ID(Env.getCtx()) == QueryConstants.BASE_ORGANIZATION_ID) {
			isViewingAnOrganization = false;
		}
		return isViewingAnOrganization;
	}

	private boolean isUserViewingAClient() {
		Boolean isViewingAClient = false;
		if (Env.getAD_Org_ID(Env.getCtx()) == QueryConstants.BASE_ORGANIZATION_ID
		        && Env.getAD_Client_ID(Env.getCtx()) != QueryConstants.BASE_CLIENT_ID) {
			isViewingAClient = true;
		}
		return isViewingAClient;
	}

	private void createIncompleteBillsWidget() {

		saleOrders = getSaleOrdersInDraftState();
		Listbox ordersInDraftListbox = new Listbox();
		ordersInDraftListbox.setEmptyMessage("No orders pending)");
		if (saleOrders != null) {
			unclosedSOCount = saleOrders.size();
			ListModelList<MOrder> model = new ListModelList<>(saleOrders, true);
			ordersInDraftListbox.setModel(model);
			ordersInDraftListbox.setItemRenderer(new DraftSaleOrderListRenderer());

			// update listmodel every 2 seconds
			TimerTask task = new TimerTask() {
				Thread refresherThread = new ModelUpdateThread(model);

				@Override
				public void run() {
					if (updatedListAvailable()) {
						unclosedSOCount = saleOrders.size();
						if (!refresherThread.isAlive()) {
							refresherThread.start();
						}
					}
				}
			};
			Timer t = new Timer();
			t.schedule(task, 2000, 5000);
			ordersInDraftListbox.addEventListener(Events.ON_SELECT, this);
		}
		Window notifications = new Window("Orders To Close: (" + saleOrders.size() + ")", "none", false);
		notifications.setStyle("z-window-popup");
		notifications.setTooltiptext("List of all orders that have not been closed");
		notifications.appendChild(ordersInDraftListbox);
		widgetArea.appendChild(notifications);
	}

	class ModelUpdateThread extends Thread {
		private ListModelList<MOrder> model;

		public ModelUpdateThread(ListModelList<MOrder> model) {
			this.model = model;
		}

		public void run() {
			Desktop desktop = DashboardMenu.this.getDesktop();
			desktop.enableServerPush(true);
			try {
				Executions.activate(desktop);
				model.clear();
				model.addAll(saleOrders);
				Executions.deactivate(desktop);
			} catch (DesktopUnavailableException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean updatedListAvailable() {
		boolean hasBeenUpdated = false;
		List<MOrder> currentList = getSaleOrdersInDraftState();
		if (currentList.size() != unclosedSOCount) {
			saleOrders = currentList;
			hasBeenUpdated = true;
		}
		return hasBeenUpdated;
	}

	private List<MOrder> getSaleOrdersInDraftState() {
		/*
		 * Calendar filterDateFrom = Calendar.getInstance();
		 * filterDateFrom.set(filterDateFrom.get(Calendar.YEAR),
		 * filterDateFrom.get(Calendar.MONTH), 1); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy-MM-dd"); String filterDateFromTxt =
		 * sdf.format(filterDateFrom.getTime()); String currentDateTxt = sdf.format(new
		 * Date());
		 */
		List<MOrder> results = new Query(Env.getCtx(), MOrder.Table_Name,
		        "docstatus = 'DR' AND issotrx = 'Y' AND  ad_client_id = " + Env.getCtx().getProperty("#AD_Client_ID"),
		        null).setOnlyActiveRecords(true).setOrderBy(MOrder.COLUMNNAME_DateOrdered + " DESC")
		                .setPageSize(MAX_RESULTS_SIZE).list();
		return results;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		String eventName = event.getName();
		if (eventName.equals(Events.ON_CLICK)) {
			if (component instanceof Grid) {
				Grid button = (Grid) component;
				Boolean termsOfUse = (Boolean) button.getAttribute(UIUtil.TERMS_OF_USE_ATTRIBUTE);
				if ((Boolean) button.getAttribute(UIUtil.REPORT_OR_PROCESS_ATTRIBUTE)) {
					int processId = Integer.parseInt(button.getId());
					try {
						SessionManager.getAppDesktop().openForm(processId);
					} catch (Exception ex) {
						SessionManager.getAppDesktop().openProcessDialog(processId, false);
					}
				} else if ((Boolean) button.getAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE)) {
					int infoWindowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openInfo(infoWindowId);
				} else if ((Boolean) button.getAttribute(UIUtil.SPECIAL_FORM_ATTRIBUTE)) {
					int infoWindowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openForm(infoWindowId);
				} else if (termsOfUse != null && termsOfUse == true) {
					// acceptTermsOfUse();
				} else if (termsOfUse != null && termsOfUse == false) {
					SessionManager.getAppDesktop().logout();
				} else {
					int windowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openWindow(windowId, null);
				}
			}
		} else if (eventName.equals(Events.ON_SELECT)) {
			Listitem selected = ((Listbox) component).getSelectedItem();
			Integer selectedDocNumber = Integer.parseInt(selected.getValue().toString());

			MWindow bhSOWindow = new Query(Env.getCtx(), MWindow.Table_Name,
			        MWindow.COLUMNNAME_Name + " LIKE '%Patient Bill%'", null).setOnlyActiveRecords(true).first();
			int windowId = bhSOWindow.getAD_Window_ID();

			MQuery query = new MQuery(MOrder.Table_Name);
			query.addRestriction(MOrder.COLUMNNAME_DocumentNo + "='" + String.valueOf(selectedDocNumber) + "' AND "
			        + MOrder.COLUMNNAME_DocStatus + "='DR'");
			SessionManager.getAppDesktop().openWindow(windowId, query, new Callback<ADWindow>() {

				@Override
				public void onCallback(ADWindow result) {
					if (result == null)
						return;
					result.getADWindowContent().onZoomAcross();
					// ADTabpanel panel =
					// (ADTabpanel)result.getADWindowContent().getADTab().getSelectedTabpanel();
					// panel.focusToFirstEditor();
				}
			});
		}
	}

}
