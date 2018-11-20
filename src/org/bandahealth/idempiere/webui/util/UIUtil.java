package org.bandahealth.idempiere.webui.util;

import org.adempiere.webui.component.Column;
import org.adempiere.webui.component.Columns;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.zkoss.zul.Div;

public class UIUtil {

	public static String INFO_WINDOW_ATTRIBUTE = "data-infowindow";
	public static String REPORT_OR_PROCESS_ATTRIBUTE = "data-process";
	public static String TERMS_OF_USE_ATTRIBUTE = "data-terms-of-use";

	public static Div initDivButton(MHomeScreenButton button) {

		Div buttonDiv = new Div();
		Grid buttonGrid = createButton(button);

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

		buttonDiv.setId(Integer.toString(windowOrInfoWindowId));
		buttonDiv.setAttribute(INFO_WINDOW_ATTRIBUTE, isInfoWindow);
		buttonDiv.setAttribute(REPORT_OR_PROCESS_ATTRIBUTE, isReportOrProcess);
		buttonDiv.setTooltiptext(button.getButtonHelpText());
		buttonDiv.setClass(button.getButtonClassName());

//		Div icon = new Div();
//		icon.setClass(button.getIconClassName() + " i");
//		buttonDiv.appendChild(icon);
//
//		Label label = new Label(button.getButtonText());
		buttonDiv.appendChild(buttonGrid);

		return buttonDiv;
	}
	
	public static Grid createButton(MHomeScreenButton button) {
		
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

		Grid buttonGrid  = new Grid();
		buttonGrid.setStyle("margin:0px; padding:0px; cursor: pointer;");
		Rows rowsContainer = new Rows();
		Columns columnsContainer = new Columns();
		Row itemRow = new Row();
		Column[] columns = new Column[2];
		for (int i = 0; i < columns.length; i++) {
			columns[i] = new Column();
			
			columns[i].setWidth((i == 0 ? "45px" : "200px"));
			columns[i].setLabel("");
			columns[i].setParent(columnsContainer);
		}
		rowsContainer.appendChild(itemRow);
		Div icon = new Div();
		icon.setClass(button.getIconClassName() + " i");
		icon.setStyle("padding:5px; font-size:25px; text-align:center;");
		Label label = new Label(button.getButtonText());
		label.setStyle("text-align:left;  vertical-align:center; padding-left:5px; border-let:none;");
		
		itemRow.appendCellChild(icon);
		itemRow.appendCellChild(label);
		buttonGrid.appendChild(columnsContainer);
		buttonGrid.appendChild(rowsContainer);
		
		buttonGrid.setId(Integer.toString(windowOrInfoWindowId));
		buttonGrid.setAttribute(INFO_WINDOW_ATTRIBUTE, isInfoWindow);
		buttonGrid.setAttribute(REPORT_OR_PROCESS_ATTRIBUTE, isReportOrProcess);
		buttonGrid.setTooltiptext(button.getButtonHelpText());
		return buttonGrid;
		
	}

}
