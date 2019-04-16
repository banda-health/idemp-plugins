package org.bandahealth.idempiere.webui;

import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.compiere.model.Query;
import org.compiere.util.Env;

/** 
 * Provide data for dashboard menu (headers and buttons)
 *
 */
public class DashboardMenuDataService {

	public DashboardMenuDataService() {
	}

	public List<MHomeScreenButtonGroup> getButtonGroups() {
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,
		        null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).list();
		return buttonGroups;
	}

	public List<MHomeScreenButton> getButtons() {
		return new Query(Env.getCtx(), MHomeScreenButton.Table_Name, null, null).setOnlyActiveRecords(true)
		        .setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo).list();
	}

}
