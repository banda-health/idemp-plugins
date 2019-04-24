package org.bandahealth.idempiere.webui.dataservice;

import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;

public class ButtonGroupDataService extends BaseDataService<MHomeScreenButtonGroup>{

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
