package org.bandahealth.idempiere.base.editor.helper;

import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.adwindow.IADTabbox;
import org.adempiere.webui.adwindow.IADTabpanel;
import org.adempiere.webui.editor.IProcessButton;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.compiere.model.I_AD_Column;

public class BHProcessButton implements IProcessButton {

	private int processId = 0;
	private IADTabpanel adTabpanel;
	private String columnName;
	private String description;
	private String display;

	public BHProcessButton(MTabNavBtn tabNavBtn, ADWindow window) {
		if (window == null || window.getADWindowContent() == null) {
			return;
		}

		I_AD_Column column = tabNavBtn.getAD_Column();
		columnName = column.getName();
		description = column.getDescription();
		processId = column.getAD_Process_ID();

		IADTabbox windowTabs = window.getADWindowContent().getADTab();
		int neededTabIndex = -1;
		int totalNumberOfTabs = windowTabs.getTabCount();
		int tableId = tabNavBtn.getAD_Table_ID();
		for (int i = 0; i < totalNumberOfTabs; i++) {
			IADTabpanel potentialTab = windowTabs.getADTabpanel(i);
			if (tableId == potentialTab.getGridTab().getAD_Table_ID()) {
				neededTabIndex = i;
				break;
			}
		}

		adTabpanel = windowTabs.getADTabpanel(neededTabIndex);
	}

	@Override
	public int getProcess_ID() {
		return processId;
	}

	@Override
	public IADTabpanel getADTabpanel() {
		return adTabpanel;
	}

	@Override
	public String getColumnName() {
		return columnName;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getDisplay() {
		return display;
	}
}
