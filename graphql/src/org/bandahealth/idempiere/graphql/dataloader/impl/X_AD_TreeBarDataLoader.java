package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_TreeBar;

/**
 * Data Loader for AD_TreeBar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeBarDataLoader extends PODataLoader<X_AD_TreeBar> {
	public static String DATALOADER_AD_TreeBar_BY_ID = "AD_TreeBarByIdDataLoader";
	public static String DATALOADER_AD_TreeBar_BY_UUID = "AD_TreeBarByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_TreeBar.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TreeBar_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TreeBar_BY_UUID;
	}
}
