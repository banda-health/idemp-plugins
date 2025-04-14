package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetClass;

/**
 * Data Loader for A_Asset_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_ClassDataLoader extends PODataLoader<MAssetClass> {
	public static String DATALOADER_A_Asset_Class_BY_ID = "A_Asset_ClassByIdDataLoader";
	public static String DATALOADER_A_Asset_Class_BY_UUID = "A_Asset_ClassByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetClass.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Class_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Class_BY_UUID;
	}
}
