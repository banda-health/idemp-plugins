package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Block;

/**
 * Data Loader for AD_WF_Block - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_BlockDataLoader extends PODataLoader<X_AD_WF_Block> {
	public static String AD_WF_Block_BY_ID_DATA_LOADER = "AD_WF_BlockByIdDataLoader";
	public static String AD_WF_Block_BY_UUID_DATA_LOADER = "AD_WF_BlockByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Block.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_Block_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_Block_BY_UUID_DATA_LOADER;
	}
}
