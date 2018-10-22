package org.bandahealth.idempiere.webui;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.MBPartner;
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
import org.zkoss.zul.AbstractListModel;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Script;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;
import org.zkoss.zul.event.ListDataEvent;
import org.zkoss.zul.event.ListDataListener;

public class DPBHDashboardPanel extends DashboardPanel implements EventListener<Event> {

	/**
	 * Custom BandaHealth dash-board with links to: -> product info window -> BH
	 * Product -> BH BusinessPartner -> BH Inventory
	 */

	private static final long serialVersionUID = 1L;
	private CLogger log = CLogger.getCLogger(DPBHDashboardPanel.class);

	private Vlayout layout = new Vlayout();
	private Div contentArea = new Div();
	private Div widgetArea = new Div();
	
	List<MOrder> saleOrders;

	public DPBHDashboardPanel() {
		super();

		this.setSclass("openmrs bh-dashboard-panel");

		initLayout();
	}

	private void initLayout() {
		layout.setParent(this);
		layout.setStyle("height: 100%; width 100%");

//		contentArea.setStyle("width:75%; float:left; padding-right:3x;");
		widgetArea.setSclass("bh-so-list-window");

		layout.appendChild(contentArea);
		layout.appendChild(widgetArea);
		contentArea.setClass("bh-dashboard-content");

		appendRoleScript();

		createPanel();
	}

	private void appendRoleScript() {
		if (isUserViewingAnOrganization()) {
			layout.appendChild(new Script("requirejs(['user/organization'], function () {});"));
		} else if (isUserViewingAClient()) {
			layout.appendChild(new Script("requirejs(['user/client'], function () {});"));
		}
	}

	public void createPanel() {
		// add links to BH custom windows
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,
				null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).list();
		List<MHomeScreenButton> buttons = new Query(Env.getCtx(), MHomeScreenButton.Table_Name, null, null)
				.setOnlyActiveRecords(true).setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo).list();
		for (MHomeScreenButtonGroup buttonGroup : buttonGroups) {
			Div groupSeparator = new Div();
			groupSeparator.setClass("bh-button-group-header");
			groupSeparator.appendChild(new Text(buttonGroup.getName()));
			contentArea.appendChild(groupSeparator);

			List<MHomeScreenButton> buttonsInGroup = buttons.stream()
					.filter(b -> b.getBH_HmScrn_ButtonGroup_ID() == buttonGroup.getBH_HmScrn_ButtonGroup_ID())
					.collect(Collectors.toList());
			Div groupContainer = new Div();
			groupContainer.setClass("bh-button-group-content");
			for (MHomeScreenButton button : buttonsInGroup) {
				Div divButton = UIUtil.initDivButton(button);
				divButton.addEventListener(Events.ON_CLICK, this);
				groupContainer.appendChild(divButton);
			}
			contentArea.appendChild(groupContainer);
		}

		createIncompleteBillsWidget();
	}

	private void createIncompleteBillsWidget() {
		getUpdatedSalesOrderList();
		Integer unclosedSOCount = 0;
		Listbox ordersInDraftListbox = new Listbox();
		ordersInDraftListbox.setEmptyMessage("No orders pending)");
		if (saleOrders != null) {
			unclosedSOCount = saleOrders.size();
			ListModelList<MOrder> model = new ListModelList<>(saleOrders);
			ordersInDraftListbox.setModel(model);

			//update listmodel every 2 seconds
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("Updating list...");
					getUpdatedSalesOrderList();
				}
			};
			Timer t = new Timer();
			t.schedule(task, 2000,5000);
			
//			for (MOrder order : saleOrders) {
//				String patientId = MBPartner.COLUMNNAME_C_BPartner_ID + "= " + String.valueOf(order.getC_BPartner_ID());
//				MBPartner patient = new Query(Env.getCtx(), MBPartner.Table_Name, patientId, null)
//						.setOnlyActiveRecords(true).first();
//				NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "KE"));
//				String orderDetails = patient.getName() == null ? "Un-named Patient"
//						: patient.getName() + ":" + formatter.format(order.getGrandTotal()) + ":"
//								+ new SimpleDateFormat("dd-MMM").format(order.getCreated());
//				Listitem listRow = new Listitem();
//				Listcell[] dataCells = new Listcell[4];// max cells to display
//				String[] orderTokens = orderDetails.split(":");
//				for (int i = 0; i < orderTokens.length; i++) {
//					dataCells[i] = new Listcell(orderTokens[i]);
//					if (i < 2) // span the name & amount cells
//						dataCells[i].setSpan(2);
//					listRow.appendChild(dataCells[i]);
//				}
//				listRow.setValue(order.getDocumentNo());
//				listRow.setSclass("bh-draft-so-list");
//				unfinishedBills.appendChild(listRow);
//				unfinishedBills.addEventListener(Events.ON_SELECT, this);
//			}
		}
		Window notifications = new Window("Orders To Close: (" + unclosedSOCount + ")", "none", false);
		notifications.setTooltiptext("List of all orders that have not been closed");
		notifications.appendChild(ordersInDraftListbox);
		widgetArea.appendChild(notifications);
	}

	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		String eventName = event.getName();
		int displayId = -1;
		if (eventName.equals(Events.ON_CLICK)) {
			if (component instanceof Div) {
				Div button = (Div) component;
				if ((boolean) button.getAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE)) {
					int processId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openProcessDialog(processId, false);
				} else if ((boolean) button.getAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE)) {
					int infoWindowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openInfo(infoWindowId);
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
	
	private void getUpdatedSalesOrderList(){
		saleOrders = new Query(Env.getCtx(), MOrder.Table_Name,
				"docstatus = 'DR' AND issotrx = 'Y' AND ad_client_id = " + Env.getCtx().getProperty("#AD_Client_ID"),
				null).setOnlyActiveRecords(true).setOrderBy(MOrder.COLUMNNAME_DateOrdered).list();
		System.out.println("Size of list Items: " + saleOrders.size());
	}
}
