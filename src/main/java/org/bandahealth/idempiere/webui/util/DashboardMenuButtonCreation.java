package org.bandahealth.idempiere.webui.util;

import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
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


	public Grid createButton(MHomeScreenButton mHomeScreenButton) {
		
		int windowOrInfoWindowId = mHomeScreenButton.getAD_Window_ID();

		boolean isInfoWindow = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = mHomeScreenButton.getAD_InfoWindow_ID();
			isInfoWindow = true;
		}
		boolean isReportOrProcess = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = mHomeScreenButton.getAD_Process_ID();
			isReportOrProcess = true;
		}
		boolean isSpecialForm = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = mHomeScreenButton.getAD_Form_ID();
			isSpecialForm = true;
		}
		
		Grid grid = (Grid) Executions.createComponents("/zul/MenuButton.zul", null, null);
		//set icon and text
		Div div = (Div) grid.query(".icn");
		Div div2 = (Div) grid.query(".lbl");
		Label label = (Label) grid.query("label");
		div.setSclass(mHomeScreenButton.getIconClassName() + " i");
		label.setValue(mHomeScreenButton.getButtonText());
		div2.appendChild(label);
		//set attributes and id
		grid.setId(Integer.toString(windowOrInfoWindowId));
		grid.setAttribute(INFO_WINDOW_ATTRIBUTE, isInfoWindow);
		grid.setAttribute(REPORT_OR_PROCESS_ATTRIBUTE, isReportOrProcess);
		grid.setAttribute(SPECIAL_FORM_ATTRIBUTE, isSpecialForm);
		grid.setTooltiptext(mHomeScreenButton.getButtonHelpText());
		//set events on button
		grid.addEventListener(Events.ON_CLICK, this);
		return grid;
	}
	
	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		String eventName = event.getName();
		System.out.println("Event is: " + event.getName());
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
		}
	}
}
