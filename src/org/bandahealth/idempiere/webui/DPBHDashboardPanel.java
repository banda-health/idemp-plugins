package org.bandahealth.idempiere.webui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.MBPartner;
import org.compiere.model.MOrder;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zhtml.Link;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Script;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

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

	public DPBHDashboardPanel() {
		super();

		this.setSclass("openmrs bh-dashboard-panel");

		initLayout();
	}

	private void initLayout() {
		layout.setParent(this);
		layout.setStyle("height: 100%; width 100%");

		contentArea.setStyle("width:75%; float:left; padding-right:5px;");
		widgetArea.setStyle("width:20%; float:right;");
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

		List<MOrder> saleOrders = new Query(Env.getCtx(), MOrder.Table_Name, "docstatus = 'DR' AND issotrx = 'Y'", null)
				.setOnlyActiveRecords(true).setOrderBy(MOrder.COLUMNNAME_DateOrdered).list();

		Listbox unfinishedBills = new Listbox();
		for (MOrder order : saleOrders) {
			String patientId = MBPartner.COLUMNNAME_C_BPartner_ID + "= " + String.valueOf(order.getC_BPartner_ID());
			A link = new A();
			MBPartner patient = new Query(Env.getCtx(), MBPartner.Table_Name, patientId, null)
					.setOnlyActiveRecords(true).first();
			link.setHref(String.valueOf(order.getC_Order_ID()));
			link.setLabel(patient.getName());
			String details = link.getLabel() + " , " + new SimpleDateFormat("dd-MM hh:mm a").format(order.getCreated());
//			unfinishedBills.appendChild(link);
			unfinishedBills.appendItem(details, order.getDocumentNo());
		}
		Window notifications = new Window("Incomplete patient bills: (" + saleOrders.size() + ")", "none", false);
		notifications.appendChild(unfinishedBills);
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
}
