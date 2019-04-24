package org.bandahealth.idempiere.webui.dataservice;

import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;

public class ButtonDataService extends BaseDataService<MHomeScreenButton>{

	@Override
	public List<MHomeScreenButton> getData() {
		List<MHomeScreenButton> buttons = buildQuery.list();
		return  buttons;
	}

	@Override
	protected String getWhereClause() {
		return null;
	}

}
