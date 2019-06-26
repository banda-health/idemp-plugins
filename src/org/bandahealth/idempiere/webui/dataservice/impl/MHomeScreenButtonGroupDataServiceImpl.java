package org.bandahealth.idempiere.webui.dataservice.impl;

import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.webui.dataservice.BaseDataService;

/**
 * Provide data for dashboard menu (headers and buttons)
 *
 */
public class MHomeScreenButtonGroupDataServiceImpl extends BaseDataService<MHomeScreenButtonGroup> {

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

	@Override
	protected String getTableName() {
		return MHomeScreenButtonGroup.Table_Name;
	}

	@Override
	protected String getTrxName() {
		return null;
	}
}
