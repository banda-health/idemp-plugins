package org.bandahealth.idempiere.webui.dataservice.impl;

import java.util.List;

import org.bandahealth.idempiere.base.model.MDashboardButtonGroup;
import org.bandahealth.idempiere.webui.dataservice.BaseDataService;

/**
 * Provide data for dashboard menu (headers and buttons)
 *
 */
public class MDashboardButtonGroupDataServiceImpl extends BaseDataService<MDashboardButtonGroup> {

	@Override
	public List<MDashboardButtonGroup> getData() {
		List<MDashboardButtonGroup> buttonGroups = buildQuery.setOrderBy(MDashboardButtonGroup.COLUMNNAME_LineNo)
		        .list();
		return buttonGroups;
	}

	@Override
	protected String getWhereClause() {
		return null;
	}

	@Override
	protected String getTableName() {
		return MDashboardButtonGroup.Table_Name;
	}

	@Override
	protected String getTrxName() {
		return null;
	}
}
