package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetAddition;

/**
 * Data Loader for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_AdditionDataLoader extends PODataLoader<MAssetAddition> {
	public static String DATALOADER_A_Asset_Addition_BY_ID = "A_Asset_AdditionByIdDataLoader";
	public static String DATALOADER_A_Asset_Addition_BY_UUID = "A_Asset_AdditionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetAddition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Addition_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Addition_BY_UUID;
	}
}
