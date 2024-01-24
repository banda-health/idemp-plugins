package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MTabNavBtn;

/**
 * Data Loader for BH_TabNavBtn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_TabNavBtnDataLoader extends PODataLoader<MTabNavBtn> {
	public static String DATALOADER_BH_TabNavBtn_BY_ID = "BH_TabNavBtnByIdDataLoader";
	public static String DATALOADER_BH_TabNavBtn_BY_UUID = "BH_TabNavBtnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTabNavBtn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_TabNavBtn_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_TabNavBtn_BY_UUID;
	}
}
