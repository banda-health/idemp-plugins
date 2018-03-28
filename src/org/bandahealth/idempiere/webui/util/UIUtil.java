package org.bandahealth.idempiere.webui.util;

import org.adempiere.webui.component.Label;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.zkoss.zul.Div;

public class UIUtil {

	public static Div initDivButton(MHomeScreenButton button) {

		Div buttonDiv = new Div();

		buttonDiv.setId(Integer.toString(button.getAD_Window_ID()));
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
