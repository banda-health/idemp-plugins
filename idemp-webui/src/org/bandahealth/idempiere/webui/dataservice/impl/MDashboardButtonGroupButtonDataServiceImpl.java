package org.bandahealth.idempiere.webui.dataservice.impl;

import java.util.List;

import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.webui.dataservice.BaseDataService;

/**
 * Provide data for dashboard menu (headers and buttons)
 *
 */
public class MDashboardButtonGroupButtonDataServiceImpl extends BaseDataService<MDashboardButtonGroupButton> {

	@Override
	public List<MDashboardButtonGroupButton> getData() {
		List<MDashboardButtonGroupButton> buttons = buildQuery.setOrderBy(MDashboardButtonGroupButton.COLUMNNAME_LineNo).list();
		return buttons;
	}

	@Override
	protected String getWhereClause() {
		return null;
	}

	@Override
	protected String getTableName() {
		return MDashboardButtonGroupButton.Table_Name;
	}

	@Override
	protected String getTrxName() {
		return null;
	}
}
