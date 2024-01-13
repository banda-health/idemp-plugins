package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MTabNavBtnTab;

/**
 * Data Loader for BH_TabNavBtn_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_TabNavBtn_TabDataLoader extends PODataLoader<MTabNavBtnTab> {
	public static String DATALOADER_BH_TabNavBtn_Tab_BY_ID = "BH_TabNavBtn_TabByIdDataLoader";
	public static String DATALOADER_BH_TabNavBtn_Tab_BY_UUID = "BH_TabNavBtn_TabByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTabNavBtnTab.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_TabNavBtn_Tab_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_TabNavBtn_Tab_BY_UUID;
	}
}
