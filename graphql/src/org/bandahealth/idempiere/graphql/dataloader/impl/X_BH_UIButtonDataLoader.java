package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MUIButton;

/**
 * Data Loader for BH_UIButton - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_UIButtonDataLoader extends PODataLoader<MUIButton> {
	public static String DATALOADER_BH_UIButton_BY_ID = "BH_UIButtonByIdDataLoader";
	public static String DATALOADER_BH_UIButton_BY_UUID = "BH_UIButtonByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUIButton.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_UIButton_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_UIButton_BY_UUID;
	}
}
