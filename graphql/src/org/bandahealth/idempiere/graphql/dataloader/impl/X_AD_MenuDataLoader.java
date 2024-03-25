package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MMenu_BH;

/**
 * Data Loader for AD_Menu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_MenuDataLoader extends PODataLoader<MMenu_BH> {
	public static String DATALOADER_AD_Menu_BY_ID = "AD_MenuByIdDataLoader";
	public static String DATALOADER_AD_Menu_BY_UUID = "AD_MenuByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMenu_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Menu_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Menu_BY_UUID;
	}
}
