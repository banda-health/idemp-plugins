package org.bandahealth.idempiere.webui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.component.Column;
import org.adempiere.webui.component.Columns;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.component.Tab;
import org.adempiere.webui.component.Tabbox;
import org.adempiere.webui.component.Tabpanel;
import org.adempiere.webui.component.Tabpanels;
import org.adempiere.webui.component.Tabs;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.MOrder;
import org.compiere.model.MQuery;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Script;

public class DashboardMenu extends DashboardPanel implements EventListener<Event> {

	private static final long serialVersionUID = 1L;
	private Hlayout layout;
	private Div sideBar;
	private Tabbox tabbox;
	private Tabs tabs;
	private Tabpanels tabpanels;
	private String[] labels = { "Patients and Vendors", "Inventory", "Cashier", "Reports", "Alerts" };

	private CLogger log = CLogger.getCLogger(DashboardMenu.class);

	public DashboardMenu() {
		super();
		initLayout();
		assembleComponents();
	}

	private void initLayout() {
		this.setSclass("openmrs bh-dashboard-panel");
		this.setMinimizable(false);
		layout = new Hlayout();
		layout.setParent(this);
		sideBar = new Div();
		sideBar.setSclass("bh-dashboard-content");
		tabbox = new Tabbox();
		tabbox.setMold("accordion");
		tabs = new Tabs();
		tabpanels = new Tabpanels();
		appendRoleScript();

	}

	private void assembleComponents() {
		tabs = createTabs(labels);
		tabpanels = createTabpanels();
		tabs.setParent(tabbox);
		tabpanels.setParent(tabbox);
		sideBar.appendChild(tabbox);
		layout.appendChild(sideBar);
	}

	private Tabs createTabs(String[] labels) {
		Tabs tabs = new Tabs();
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,
				null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).list();
		for (MHomeScreenButtonGroup buttonGroup : buttonGroups) {
			log.info(buttonGroup.getName());
			Tab tab = new Tab(buttonGroup.getName());
			tabs.appendChild(tab);
		}
		return tabs;
	}

	private Tabpanels createTabpanels() {
		Tabpanels tabpanelsContainer = new Tabpanels();
		List<Tabpanel> tabpanelsList = new ArrayList<Tabpanel>();
		//get all button groups
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,
				null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).list();
		
		for (MHomeScreenButtonGroup buttonGroup : buttonGroups) {
		//get all buttons
		List<MHomeScreenButton> buttons = new Query(Env.getCtx(), MHomeScreenButton.Table_Name, null, null)
				.setOnlyActiveRecords(true).setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo).list();

		//filter buttons matching current group
		List<MHomeScreenButton> buttonsInGroup = buttons.stream()
				.filter(b -> b.getBH_HmScrn_ButtonGroup_ID() == buttonGroup.getBH_HmScrn_ButtonGroup_ID())
				.collect(Collectors.toList());
		
		Grid grid = new Grid();
		Columns columns = new Columns();
		Rows rows = new Rows();
		Column[] col = { new Column("")};
		for (int i = 0; i < col.length; i++) {
			col[i].setParent(columns);
		}
		grid.appendChild(columns);
		grid.appendChild(rows);
		//create a tabpanel using these buttons as rows...
//		Div groupContainer = new Div();
		rows.setSclass("bh-button-group-content");
		for (MHomeScreenButton button : buttonsInGroup) {
			Row row = new Row();
			Div divButton = UIUtil.initDivButton(button);
			row.appendChild(divButton);
			row.setParent(rows);
			divButton.addEventListener(Events.ON_CLICK, this);
		}
		Tabpanel panel = new Tabpanel();
		panel.appendChild(grid);
		tabpanelsContainer.appendChild(panel);
		
		}
		return tabpanelsContainer;
	}
	
	private void appendRoleScript() {
		if (isUserViewingAnOrganization()) {
			layout.appendChild(new Script("requirejs(['user/organization'], function () {});"));
		} else if (isUserViewingAClient()) {
			layout.appendChild(new Script("requirejs(['user/client'], function () {});"));
		}
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

	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		String eventName = event.getName();
		if (eventName.equals(Events.ON_CLICK)) {
			if (component instanceof Div) {
				Div button = (Div) component;
				Boolean termsOfUse = (Boolean)button.getAttribute(UIUtil.TERMS_OF_USE_ATTRIBUTE);
				if ((Boolean)button.getAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE)) {
					int processId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openProcessDialog(processId, false);
				} else if ((Boolean)button.getAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE)) {
					int infoWindowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openInfo(infoWindowId);
				} else if (termsOfUse != null && termsOfUse == true) {
//						acceptTermsOfUse();
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
					MWindow.COLUMNNAME_Name + " LIKE '%BH Sale%'", null).setOnlyActiveRecords(true).first();
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
//					ADTabpanel panel = (ADTabpanel)result.getADWindowContent().getADTab().getSelectedTabpanel();
//					panel.focusToFirstEditor();		
				}
			});
		}
	}

}
