package org.bandahealth.idempiere.webui;

import java.util.List;
import java.util.Properties;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.webui.dataservice.BaseDataService;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Provide data for dashboard menu (headers and buttons)
 *
 */
public class DashboardMenuDataService extends BaseDataService<MHomeScreenButtonGroup> {

	public DashboardMenuDataService(MHomeScreenButtonGroup object) {
		super(object);
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

	@Override
	public List<MHomeScreenButtonGroup> getData() {
		List<MHomeScreenButtonGroup> buttonGroups = buildQuery.setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo)
		        .list();
		return buttonGroups;
	}

	@Override
	protected String getWhereClause() {
		return null;
	}
}
