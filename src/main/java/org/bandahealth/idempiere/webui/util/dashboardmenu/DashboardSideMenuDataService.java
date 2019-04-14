package org.bandahealth.idempiere.webui.util.dashboardmenu;

import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class DashboardSideMenuDataService {
	
	public DashboardSideMenuDataService() {}

	public List<MHomeScreenButtonGroup> getButtonGroups() {
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,
		        null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).list();
		return buttonGroups;
	}

	public List<MHomeScreenButton> getButtonsInButtonGroup(Integer buttonGroupId) {
		String where = MHomeScreenButtonGroup.COLUMNNAME_BH_HmScrn_ButtonGroup_ID + buttonGroupId;
		List<MHomeScreenButton> buttons = new Query(Env.getCtx(), MHomeScreenButton.Table_Name, where,
		        null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButton.COLUMNNAME_BH_HmScrn_ButtonGroupLine_ID).list();
		return buttons;
	}
	
	public List<MHomeScreenButton> getButtons(){
		return new Query(Env.getCtx(), MHomeScreenButton.Table_Name, null, null)
		        .setOnlyActiveRecords(true).setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo).list();
	}

}
