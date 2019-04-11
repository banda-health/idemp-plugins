package org.bandahealth.idempiere.webui.util;

import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class DashboardSideMenuDataPopulator {

	public List<MHomeScreenButtonGroup> getButtonGroups() {
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,
		        null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).list();
		return buttonGroups;
	}

	public List<MHomeScreenButton> getButtonsInButtonGroup(Integer buttonGroupId) {
		List<MHomeScreenButton> buttonsInGroup = null;
		return buttonsInGroup;
	}

}
