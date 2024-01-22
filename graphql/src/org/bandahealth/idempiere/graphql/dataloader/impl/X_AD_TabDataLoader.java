package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTab;

/**
 * Data Loader for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TabDataLoader extends PODataLoader<MTab> {
	public static String DATALOADER_AD_Tab_BY_ID = "AD_TabByIdDataLoader";
	public static String DATALOADER_AD_Tab_BY_UUID = "AD_TabByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTab.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Tab_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Tab_BY_UUID;
	}
}
