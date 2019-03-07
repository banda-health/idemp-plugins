package org.bandahealth.idempiere.webui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroup;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.webui.util.DraftSaleOrderListRenderer;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.MOrder;
import org.compiere.model.MQuery;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Script;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;
import org.adempiere.webui.component.Label;

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

	private List<MOrder> saleOrders;
	private Integer unclosedSOCount = 0;

	public DPBHDashboardPanel() {
		super();
		
		this.setSclass("openmrs bh-dashboard-panel");

		initLayout();
	}
	
	private void initLayout() {
		layout.setParent(this);

		widgetArea.setSclass("bh-so-list-window");

		layout.appendChild(contentArea);
		layout.appendChild(widgetArea);
		
		contentArea.setClass("bh-dashboard-content");

		appendRoleScript();
		
		if (hasAcceptedTermsOfUse()) {
			createPanel();
		} else {
			createTOSPrivacyPolicyPanel();	
		}
	}

	private void appendRoleScript() {
		if (isUserViewingAnOrganization()) {
			layout.appendChild(new Script("requirejs(['user/organization'], function () {});"));
		} else if (isUserViewingAClient()) {
			layout.appendChild(new Script("requirejs(['user/client'], function () {});"));
		}
	}

	private void createPanel() {
		//add links to BH custom windows
		List<MDashboardButtonGroup> buttonGroups = new Query(Env.getCtx(), MDashboardButtonGroup.Table_Name, null,null)
				.setOnlyActiveRecords(true)
				.setOrderBy(MDashboardButtonGroup.COLUMNNAME_LineNo)
				.list();
		List<MDashboardButtonGroupButton> buttons = new Query(Env.getCtx(), MDashboardButtonGroupButton.Table_Name, null,null)
				.setOnlyActiveRecords(true)
				.setOrderBy(MDashboardButtonGroupButton.COLUMNNAME_LineNo)
				.list();

		for (MDashboardButtonGroup buttonGroup : buttonGroups) {
			Div groupSeparator = new Div();
			groupSeparator.setClass("bh-button-group-header");
			groupSeparator.appendChild(new Text(buttonGroup.getName()));
			contentArea.appendChild(groupSeparator);

			List<MDashboardButtonGroupButton> buttonsInGroup = buttons.stream()
					.filter(b -> b.getBH_DbrdBtnGrp_ID() == buttonGroup.getBH_DbrdBtnGrp_ID())
					.collect(Collectors.toList());
			Div groupContainer = new Div();
			groupContainer.setClass("bh-button-group-content");
			for (MDashboardButtonGroupButton button : buttonsInGroup) {
				Div divButton = UIUtil.initDivButton(button, Env.getContext(Env.getCtx(), "#AD_Language"));
				divButton.addEventListener(Events.ON_CLICK, this);
				groupContainer.appendChild(divButton);
			}
			contentArea.appendChild(groupContainer);
		}

		createIncompleteBillsWidget();
	}

	private void createIncompleteBillsWidget() {

		saleOrders = getDraftedSOList();
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
		notifications.setTooltiptext("List of all orders that have not been closed");
		notifications.appendChild(ordersInDraftListbox);
		widgetArea.appendChild(notifications);
	}
	
	private void createTOSPrivacyPolicyPanel() {
		// heading section
		Div groupSeparator = new Div();
		groupSeparator.setClass("bh-button-group-header");
		groupSeparator.appendChild(new Text("Terms Of Service - Banda Health Solutions"));
		
		contentArea.appendChild(groupSeparator);
		
		Div groupContainer = new Div();
		groupContainer.setClass("bh-button-group-content");
		
		// content section
		Div contentSection = new Div();
		contentSection.appendChild(new Html(getTermsAndConditionsContent()));
		
		groupContainer.appendChild(contentSection);
		
		// button section
		Div buttonsSection = new Div();
		buttonsSection.setClass("bh-tab-nav-buttons z-div");
		
		Div acceptButton = new Div();
		acceptButton.setClass("btn btn-confirm z-div");
		acceptButton.setStyle("width:120px");
		
		Div icon = new Div();
		icon.setClass("fas fa-chevron-right i");
		acceptButton.appendChild(icon);
		
		Label label = new Label(" Accept ");
		label.setStyle("color: white");
		acceptButton.appendChild(label);
		acceptButton.setAttribute(UIUtil.TERMS_OF_USE_ATTRIBUTE, true);
		acceptButton.setAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE, false);
		acceptButton.setAttribute(UIUtil.REPORT_OR_PROCESS_ATTRIBUTE, false);
		acceptButton.addEventListener(Events.ON_CLICK, this);
		buttonsSection.appendChild(acceptButton);
		
		Div rejectButton = new Div();
		rejectButton.setClass("img-btn z-button");
		rejectButton.setStyle("width:120px");
		
		Div cancelIcon = new Div();
		cancelIcon.setClass("fas fa-ban i");
		rejectButton.appendChild(cancelIcon);
		
		Label rejectLabel = new Label(" Reject ");
		rejectButton.appendChild(rejectLabel);
		rejectButton.setAttribute(UIUtil.TERMS_OF_USE_ATTRIBUTE, false);
		rejectButton.setAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE, false);
		rejectButton.setAttribute(UIUtil.REPORT_OR_PROCESS_ATTRIBUTE, false);
		rejectButton.addEventListener(Events.ON_CLICK, this);
		buttonsSection.appendChild(rejectButton);
		
		groupContainer.appendChild(buttonsSection);
		
		contentArea.appendChild(groupContainer);
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
						acceptTermsOfUse();
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
	
	private boolean hasAcceptedTermsOfUse() {
		String whereClause = MUser_BH.COLUMNNAME_AD_User_ID + "=" + Env.getAD_User_ID(Env.getCtx()) + 
				" AND " + MUser_BH.COLUMNNAME_BH_HasAcceptedTermsOfUse + "='Y'";
		return new Query(Env.getCtx(),MUser_BH.Table_Name, whereClause, null)
					.setOnlyActiveRecords(true)
					.match();
	}
	
	private void acceptTermsOfUse() {
		MUser_BH user = new MUser_BH(Env.getCtx(), Env.getAD_User_ID(Env.getCtx()), null);
		user.setBH_HasAcceptedTermsOfUse(true);
		user.save();

		layout.appendChild(
				new Script("window.location.reload();"));
	}
	
	private String getTermsAndConditionsContent(){ 
		String termsAndConditions = null;
		InputStream iReader = this.getClass().getClassLoader().getResourceAsStream("resources/TermsAndConditions.txt");
		
		if (iReader != null) {
			try (BufferedReader bReader = new BufferedReader(new InputStreamReader(iReader))) {
				StringBuilder sBuilder = new StringBuilder();
				String line = bReader.readLine();
				while (line != null) {
					sBuilder.append(line);
					sBuilder.append("<br />");
					line = bReader.readLine();
				}
				termsAndConditions = sBuilder.toString();
			} catch (IOException ex) {
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		return termsAndConditions;
	}
	
	private boolean updatedListAvailable() {
		boolean hasBeenUpdated = false;
		List<MOrder> currentList = getDraftedSOList();
		if (currentList.size() != unclosedSOCount) {
			saleOrders = currentList;
			hasBeenUpdated = true;
		}
		return hasBeenUpdated;
	}

	private List<MOrder> getDraftedSOList() {
		Calendar filterDateFrom = Calendar.getInstance();
		filterDateFrom.set(filterDateFrom.get(Calendar.YEAR), filterDateFrom.get(Calendar.MONTH), 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String filterDateFromTxt = sdf.format(filterDateFrom.getTime());
		String currentDateTxt = sdf.format(new Date());

		List<MOrder> results = new Query(Env.getCtx(), MOrder.Table_Name,
				"docstatus = 'DR' AND issotrx = 'Y' AND " + MOrder.COLUMNNAME_DateOrdered + " BETWEEN '" + filterDateFromTxt
						+ "' AND '" + currentDateTxt + "' AND ad_client_id = " + Env.getCtx().getProperty("#AD_Client_ID"),
				null).setOnlyActiveRecords(true).setOrderBy(MOrder.COLUMNNAME_DateOrdered).list();
		return results;
	}

	class ModelUpdateThread extends Thread {
		private ListModelList<MOrder> model;

		public ModelUpdateThread(ListModelList<MOrder> model) {
			this.model = model;
		}

		public void run() {
			Desktop desktop = DPBHDashboardPanel.this.getDesktop();
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
}
