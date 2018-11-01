package org.bandahealth.idempiere.webui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.webui.component.Label;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;
import org.zkoss.zul.Script;
import org.zkoss.zul.Vlayout;

public class DPBHDashboardPanel extends DashboardPanel implements EventListener<Event> {

	/**
	 * Custom BandaHealth dash-board with links to:
	 * -> product info window
	 * -> BH Product
	 * -> BH BusinessPartner
	 * -> BH Inventory
	 */

	private static final long serialVersionUID = 1L;
	private CLogger log = CLogger.getCLogger(DPBHDashboardPanel.class);

	private static Vlayout layout = new Vlayout();
	private static Div contentArea = new Div();

	public DPBHDashboardPanel() {
		super();

		this.setSclass("openmrs bh-dashboard-panel");

		initLayout();
	}
	
	private void initLayout() {
		layout.setParent(this);
		layout.setStyle("height: 100%; width 100%");

		layout.appendChild(contentArea);
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
			layout.appendChild(
					new Script("requirejs(['user/organization'], function () {});"));
		} else if (isUserViewingAClient()) {
			layout.appendChild(
					new Script("requirejs(['user/client'], function () {});"));
		}
	}

	private void createPanel() {
		//add links to BH custom windows
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,null)
				.setOnlyActiveRecords(true)
				.setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo)
				.list();
		List<MHomeScreenButton> buttons = new Query(Env.getCtx(), MHomeScreenButton.Table_Name, null,null)
				.setOnlyActiveRecords(true)
				.setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo)
				.list();
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
				if (button.getAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE) != null) {
					int processId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openProcessDialog(processId, false);
				} else if (button.getAttribute(UIUtil.INFO_WINDOW_ATTRIBUTE) != null) {
					int infoWindowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openInfo(infoWindowId);
				} else if (termsOfUse != null) {
					if (termsOfUse) {
						acceptTermsOfUse();
					} else {
						SessionManager.getAppDesktop().logout();
					}
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
}
