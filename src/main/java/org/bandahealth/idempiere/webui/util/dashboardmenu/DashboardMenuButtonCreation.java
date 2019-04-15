package org.bandahealth.idempiere.webui.util.dashboardmenu;

import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;

public class DashboardMenuButtonCreation implements EventListener<Event> {

	public static String INFO_WINDOW_ATTRIBUTE = "data-infowindow";
	public static String SPECIAL_FORM_ATTRIBUTE = "special-form";
	public static String REPORT_OR_PROCESS_ATTRIBUTE = "data-process";
	public static String TERMS_OF_USE_ATTRIBUTE = "data-terms-of-use";

	boolean isInfoWindow = false;
	boolean isReportOrProcess = false;
	boolean isSpecialForm = false;
	int windowOrInfoWindowId;

	public void setButtonType(MHomeScreenButton mHomeScreenButton) {
		int windowOrInfoWindowId = mHomeScreenButton.getAD_Window_ID();

		isInfoWindow = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = mHomeScreenButton.getAD_InfoWindow_ID();
			isInfoWindow = true;
		}
		isReportOrProcess = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = mHomeScreenButton.getAD_Process_ID();
			isReportOrProcess = true;
		}
		isSpecialForm = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = mHomeScreenButton.getAD_Form_ID();
			isSpecialForm = true;
		}
	}

	public Grid createButton(MHomeScreenButton mHomeScreenButton) {
		setButtonType(mHomeScreenButton);
		Grid buttonGrid = (Grid) Executions.createComponents("/zul/MenuButton.zul", null, null);
		Div menuIcon = (Div) buttonGrid.query(".icn");
		Div menuText = (Div) buttonGrid.query(".lbl");
		Label string = (Label) buttonGrid.query("label");
		menuIcon.setSclass(mHomeScreenButton.getIconClassName() + " i");
		string.setValue(mHomeScreenButton.getButtonText());
		menuText.appendChild(string);
		buttonGrid.setId(Integer.toString(windowOrInfoWindowId));
		buttonGrid.setAttribute(INFO_WINDOW_ATTRIBUTE, isInfoWindow);
		buttonGrid.setAttribute(REPORT_OR_PROCESS_ATTRIBUTE, isReportOrProcess);
		buttonGrid.setAttribute(SPECIAL_FORM_ATTRIBUTE, isSpecialForm);
		buttonGrid.setTooltiptext(mHomeScreenButton.getButtonHelpText());
		buttonGrid.addEventListener(Events.ON_CLICK, this);
		return buttonGrid;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		String eventName = event.getName();
		if (eventName.equals(Events.ON_CLICK)) {
			if (component instanceof Grid) {
				Grid button = (Grid) component;
				Boolean termsOfUse = (Boolean) button.getAttribute(TERMS_OF_USE_ATTRIBUTE);
				if ((Boolean) button.getAttribute(REPORT_OR_PROCESS_ATTRIBUTE)) {
					int processId = Integer.parseInt(button.getId());
					try {
						SessionManager.getAppDesktop().openForm(processId);
					} catch (Exception ex) {
						SessionManager.getAppDesktop().openProcessDialog(processId, false);
					}
				} else if ((Boolean) button.getAttribute(INFO_WINDOW_ATTRIBUTE)) {
					int infoWindowId = Integer.parseInt(button.getId());
					SessionManager.getAppDesktop().openInfo(infoWindowId);
				} else if ((Boolean) button.getAttribute(SPECIAL_FORM_ATTRIBUTE)) {
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
			//TODO Add event handler for open bills widget
		}
	}
}
