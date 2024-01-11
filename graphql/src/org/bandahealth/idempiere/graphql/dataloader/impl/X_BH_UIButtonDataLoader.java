package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MUIButton;

/**
 * Data Loader for BH_UIButton - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_UIButtonDataLoader extends PODataLoader<MUIButton> {
	public static String BH_UIButton_BY_ID_DATA_LOADER = "BH_UIButtonByIdDataLoader";
	public static String BH_UIButton_BY_UUID_DATA_LOADER = "BH_UIButtonByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUIButton.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_UIButton_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_UIButton_BY_UUID_DATA_LOADER;
	}
}
