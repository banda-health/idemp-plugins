package org.bandahealth.idempiere.webui;

import java.util.List;
import java.util.Properties;

import org.adempiere.webui.component.ToolBarButton;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Script;
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
	private CLogger log = CLogger.getCLogger(DPBHDashboard.class);

	private Vlayout layout = new Vlayout();
	private Div contentArea = new Div();

	private final String DEFAULT_TOOL_ICON = "Server24.png";

	public DPBHDashboard() {
		super();

		this.setSclass("openmrs");

		initLayout();
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
		layout.appendChild(new Script("bandahealth.initPage()"));
		if (isOrgAccessLevel()) {
			layout.appendChild(new Script("bandahealth.userIsOrg()"));
		} else {
			layout.appendChild(new Script("bandahealth.userIsClientAndOrg()"));
		}
	}

	public void createPanel() {
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
			if (component instanceof Div) {
				Div button = (Div) component;
				if ((boolean) button.getAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE)) {
					int infoWindowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openInfo(infoWindowId);
				} else {
					int windowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openWindow(windowId, null);
				}
			}
		}
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

	private Boolean isOrgAccessLevel() {
		Boolean isViewingAnOrganization = true;
		if (Env.getAD_Org_ID(Env.getCtx()) == 0) {
			isViewingAnOrganization = false;
		}
		return isViewingAnOrganization;
	}
}
