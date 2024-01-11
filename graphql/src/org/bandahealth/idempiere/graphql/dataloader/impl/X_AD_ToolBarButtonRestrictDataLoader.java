package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MToolBarButtonRestrict;

/**
 * Data Loader for AD_ToolBarButtonRestrict - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ToolBarButtonRestrictDataLoader extends PODataLoader<MToolBarButtonRestrict> {
	public static String AD_ToolBarButtonRestrict_BY_ID_DATA_LOADER = "AD_ToolBarButtonRestrictByIdDataLoader";
	public static String AD_ToolBarButtonRestrict_BY_UUID_DATA_LOADER = "AD_ToolBarButtonRestrictByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MToolBarButtonRestrict.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ToolBarButtonRestrict_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ToolBarButtonRestrict_BY_UUID_DATA_LOADER;
	}
}
