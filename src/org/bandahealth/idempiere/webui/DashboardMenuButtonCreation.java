package org.bandahealth.idempiere.webui;

import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
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

	public boolean isReportOrProcess = true;
	public boolean isSpecialForm = false;
	public int windowOrInfoWindowId;

	public void setButtonType(MDashboardButtonGroupButton dashboardButtonGroupButton) {
		windowOrInfoWindowId = dashboardButtonGroupButton.getAD_Window_ID();

		isReportOrProcess = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = dashboardButtonGroupButton.getAD_Process_ID();
			isReportOrProcess = true;
		}
		isSpecialForm = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = dashboardButtonGroupButton.getAD_Form_ID();
			isSpecialForm = true;
		}
	}

	public Grid createButton(MDashboardButtonGroupButton dashboardButtonGroupButton, String usersLanguage) {
		setButtonType(dashboardButtonGroupButton);
		Grid buttonGrid = (Grid) Executions.createComponents("/zul/MenuButton.zul", null, null);
		Div menuIcon = (Div) buttonGrid.query(".icn");
		Div menuText = (Div) buttonGrid.query(".lbl");
		Label string = (Label) buttonGrid.query("label");
		menuIcon.setSclass(dashboardButtonGroupButton.getIconClassName() + " i");
		string.setValue(dashboardButtonGroupButton.get_Translation(MDashboardButtonGroupButton.COLUMNNAME_ButtonText,
				usersLanguage));
		menuText.appendChild(string);
		buttonGrid.setId(Integer.toString(windowOrInfoWindowId));
		buttonGrid.setAttribute(REPORT_OR_PROCESS_ATTRIBUTE, isReportOrProcess);
		buttonGrid.setAttribute(SPECIAL_FORM_ATTRIBUTE, isSpecialForm);
		buttonGrid.setTooltiptext(dashboardButtonGroupButton.get_Translation(
				MDashboardButtonGroupButton.COLUMNNAME_ButtonText, usersLanguage));
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
				int targetId = Integer.parseInt(button.getId());
				if ((Boolean) button.getAttribute(REPORT_OR_PROCESS_ATTRIBUTE)) {
					try {
						SessionManager.getAppDesktop().openForm(targetId);
					} catch (Exception ex) {
						SessionManager.getAppDesktop().openProcessDialog(targetId, false);
					}
				} else if ((Boolean) button.getAttribute(SPECIAL_FORM_ATTRIBUTE)) {
					SessionManager.getAppDesktop().openForm(targetId);
				} else {
					SessionManager.getAppDesktop().openWindow(targetId, null);
				}
			}
			//TODO Add event handler for open bills widget
		}
	}
}
