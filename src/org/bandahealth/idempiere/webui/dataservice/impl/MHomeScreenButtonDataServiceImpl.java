package org.bandahealth.idempiere.webui.dataservice.impl;

import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.webui.dataservice.BaseDataService;

/**
 * Provide data for dashboard menu (headers and buttons)
 *
 */
public class MHomeScreenButtonDataServiceImpl extends BaseDataService<MHomeScreenButton> {

	@Override
	public List<MHomeScreenButton> getData() {
		List<MHomeScreenButton> buttons = buildQuery.setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo).list();
		return buttons;
	}

	@Override
	protected String getWhereClause() {
		return null;
	}

	@Override
	protected String getTableName() {
		return MHomeScreenButton.Table_Name;
	}

	@Override
	protected String getTrxName() {
		return null;
	}
}
