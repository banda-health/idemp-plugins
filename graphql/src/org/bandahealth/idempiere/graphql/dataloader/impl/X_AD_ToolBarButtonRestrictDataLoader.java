package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MToolBarButtonRestrict;

/**
 * Data Loader for AD_ToolBarButtonRestrict - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ToolBarButtonRestrictDataLoader extends PODataLoader<MToolBarButtonRestrict> {
	public static String DATALOADER_AD_ToolBarButtonRestrict_BY_ID = "AD_ToolBarButtonRestrictByIdDataLoader";
	public static String DATALOADER_AD_ToolBarButtonRestrict_BY_UUID = "AD_ToolBarButtonRestrictByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MToolBarButtonRestrict.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ToolBarButtonRestrict_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ToolBarButtonRestrict_BY_UUID;
	}
}
