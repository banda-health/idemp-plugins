package org.bandahealth.idempiere.webui;

import java.util.List;
import java.util.Properties;

import org.adempiere.webui.component.ToolBarButton;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.adempiere.webui.theme.ThemeManager;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Util;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Box;
import org.zkoss.zul.Div;
import org.zkoss.zul.Script;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;

public class DPBHDashboard extends DashboardPanel implements EventListener<Event> {

	/**
	 * Custom BandaHealth dash-board with links to:
	 * -> product info window
	 * -> BH Product
	 * -> BH BusinessPartner
	 * -> BH Inventory
	 */

	private static final long serialVersionUID = 1L;
	private CLogger logger = CLogger.getCLogger(DPBHDashboard.class);

	private Div layout = new Div();
	private Div contentArea = new Div();

	private int clientId;
	private int userId;
	private int roleId;
	private int orgId;

	private final String DEFAULT_TOOL_ICON = "Server24.png";

	public DPBHDashboard() {
		super();

		this.setSclass("openmrs");

		initLayout();
		Properties context = Env.getCtx();
		clientId = Env.getAD_Client_ID(context);
		orgId = Env.getAD_Org_ID(context);
		userId = Env.getAD_User_ID(context);
		roleId = Env.getAD_Role_ID(context);
	}

	private void initLayout() {
		layout.setParent(this);
		layout.setStyle("height: 100%; width 100%");

		layout.appendChild(contentArea);
		contentArea.setClass("bh-dashboard-content");

		appendRoleScript();

		createPanel();
	}

	private void appendRoleScript() {
		if (isOrgAccessLevel()) {
			layout.appendChild(new Script("bandahealth.userIsOrg()"));
		} else {
			layout.appendChild(new Script("bandahealth.userIsClientAndOrg()"));
		}
	}

	public void createPanel() {
		MInfoWindow productInfoWindow = filterFromViews("Product Info");
		if (productInfoWindow != null) {
			ToolBarButton button = createPanelButton(productInfoWindow.getName(),
					"link",
					productInfoWindow.get_Translation("Name"),
					productInfoWindow.getImageURL());
			button.addEventListener(Events.ON_CLICK, this);
			contentArea.appendChild(button);
		}

		//add links to BH custom windows
		List<MHomeScreenButton> buttons = getHomeScreenButtons();
		for (MHomeScreenButton button : buttons) {
			Div divButton = UIUtil.initDivButton(button);
			divButton.addEventListener(Events.ON_CLICK, this);
			contentArea.appendChild(divButton);
		}
	}

	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		String eventName = event.getName();
		int displayId = -1;
		if (eventName.equals(Events.ON_CLICK)) {
			if (component instanceof ToolBarButton) {
				ToolBarButton button = (ToolBarButton) component;
				String windowName = button.getName();
				if (windowName.equals("Product Info")) {
					displayId = getWindowId(windowName, MInfoWindow.Table_Name);
					SessionManager.getAppDesktop().openInfo(displayId);
				} else {
					displayId = getWindowId(windowName, MWindow.Table_Name);
					SessionManager.getAppDesktop().openWindow(displayId, null);
				}
			} else if (component instanceof Div) {
				Div button = (Div) component;
				int windowId = Integer.parseInt(button.getId());
				SessionManager.getAppDesktop().openWindow(windowId, null);
			}
		}
	}

	/*
	 * Get listing of dashboard views and filter only
	 * the product info view
	 */
	private MInfoWindow filterFromViews(String viewName) {
		MInfoWindow productInfoWin = null;
		List<MInfoWindow> list = new Query(
				Env.getCtx(),
				MInfoWindow.Table_Name,
				"IsValid='Y' AND IsShowInDashboard='Y'",
				null).setOnlyActiveRecords(true).list();
		for (MInfoWindow currentWindow : list) {
			if (currentWindow.getName().contains(viewName)) {
				productInfoWin = currentWindow;
			}
		}
		return productInfoWin;
	}

	/* Get all custom BH windows
	 * Assumes every custom table needed is prefixed with BH
	 */
	private List<MHomeScreenButton> getHomeScreenButtons() {
		return new Query(Env.getCtx(), MHomeScreenButton.Table_Name, null,null)
				.setOnlyActiveRecords(true)
				.setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo)
				.list();
	}

	/*
	 * Get the ID of the window to be displayed
	 */
	private int getWindowId(String windowName, String windowType) {
		int windowToDisplay = new Query(Env.getCtx(),
				windowType,
				"Name = ?",
				null).setParameters(windowName).setOnlyActiveRecords(true).firstIdOnly();
		return windowToDisplay;
	}

	/*Create toolbar buttons for the panel*/
	private ToolBarButton createPanelButton(String name, String styleClass, String label, String image) {
		ToolBarButton itemLink = new ToolBarButton(name);
		itemLink.setSclass(styleClass);
		itemLink.setLabel(label);
		itemLink.setImage(
				ThemeManager.getThemeResource("images/" +
						(Util.isEmpty(image) ? image : DEFAULT_TOOL_ICON)));
		return itemLink;
	}

	public Boolean isOrgAccessLevel() {
		Boolean orgAccessLevel = false;
		if (orgId > 0) {
			orgAccessLevel = true;
		}
		return orgAccessLevel;
	}
}
