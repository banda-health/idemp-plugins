package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetType;

/**
 * Data Loader for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_TypeDataLoader extends PODataLoader<MAssetType> {
	public static String DATALOADER_A_Asset_Type_BY_ID = "A_Asset_TypeByIdDataLoader";
	public static String DATALOADER_A_Asset_Type_BY_UUID = "A_Asset_TypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Type_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Type_BY_UUID;
	}
}
