package org.bandahealth.idempiere.webui.util;

import org.adempiere.webui.component.Column;
import org.adempiere.webui.component.Columns;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.zkoss.zul.Div;

public class UIUtil {

	public static String INFO_WINDOW_ATTRIBUTE = "data-infowindow";
	public static String SPECIAL_FORM_ATTRIBUTE = "special-form";
	public static String REPORT_OR_PROCESS_ATTRIBUTE = "data-process";
	public static String TERMS_OF_USE_ATTRIBUTE = "data-terms-of-use";

	public static Div initDivButton(MDashboardButtonGroupButton button, String usersLanguage) {

		Div buttonDiv = new Div();
		Grid buttonGrid = createButton(button, usersLanguage);
		buttonDiv.appendChild(buttonGrid);
		return buttonDiv;
	}

	public static Grid createButton(MDashboardButtonGroupButton button, String usersLanguage) {

		int windowOrInfoWindowId = button.getAD_Window_ID();

		boolean isInfoWindow = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = button.getAD_InfoWindow_ID();
			isInfoWindow = true;
		}
		boolean isReportOrProcess = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = button.getAD_Process_ID();
			isReportOrProcess = true;
		}
		boolean isSpecialForm = false;
		if (windowOrInfoWindowId == 0) {
			windowOrInfoWindowId = button.getAD_Form_ID();
			isSpecialForm = true;
		}

		Grid buttonGrid = new Grid();
		buttonGrid.setStyle("margin:0px; padding:0px; cursor: pointer;");
		Rows rowsContainer = new Rows();
		Columns columnsContainer = new Columns();
		Row itemRow = new Row();
		Column[] columns = new Column[2];
		for (int i = 0; i < columns.length; i++) {
			columns[i] = new Column();

			columns[i].setWidth((i == 0 ? "45px" : "200px"));
			columns[i].setParent(columnsContainer);
		}
		rowsContainer.appendChild(itemRow);
		Div icon = new Div();
		icon.setClass(button.getIconClassName() + " i");
		icon.setStyle("padding:3px; font-size:20px; text-align:center; vertical-align:middle;");
		Label label = new Label(button.get_Translation(MDashboardButtonGroupButton.COLUMNNAME_ButtonText, usersLanguage));
		label.setStyle("text-align:left;  vertical-align:middle; padding-left:5px;");

		itemRow.appendCellChild(icon);
		itemRow.appendCellChild(label);
		buttonGrid.appendChild(columnsContainer);
		buttonGrid.appendChild(rowsContainer);

		buttonGrid.setId(Integer.toString(windowOrInfoWindowId));
		buttonGrid.setAttribute(INFO_WINDOW_ATTRIBUTE, isInfoWindow);
		buttonGrid.setAttribute(REPORT_OR_PROCESS_ATTRIBUTE, isReportOrProcess);
		buttonGrid.setAttribute(SPECIAL_FORM_ATTRIBUTE, isSpecialForm);
		buttonGrid.setTooltiptext(
				button.get_Translation(MDashboardButtonGroupButton.COLUMNNAME_ButtonHelpText, usersLanguage));
		return buttonGrid;

	}

}
