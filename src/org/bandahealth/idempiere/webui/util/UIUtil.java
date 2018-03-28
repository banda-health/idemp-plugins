package org.bandahealth.idempiere.webui.util;

import org.adempiere.webui.component.Label;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.zkoss.zul.Div;

public class UIUtil {

	public static String INFO_WINDOW_ATTRIBUTE = "data-infowindow";

	public static Div initDivButton(MHomeScreenButton button) {

		Div buttonDiv = new Div();

		int windowOrInfoWindowId = button.getAD_Window_ID();
		boolean isInfoWindow = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = button.getAD_InfoWindow_ID();
			isInfoWindow = true;
		}
		buttonDiv.setId(Integer.toString(windowOrInfoWindowId));
		buttonDiv.setAttribute(INFO_WINDOW_ATTRIBUTE, isInfoWindow);
		buttonDiv.setTooltiptext(button.getButtonHelpText());
		buttonDiv.setClass(button.getButtonClassName());

		Div icon = new Div();
		icon.setClass(button.getIconClassName() + " i");
		buttonDiv.appendChild(icon);

		Label label = new Label(button.getButtonText());
		buttonDiv.appendChild(label);

		return buttonDiv;
	}

}
