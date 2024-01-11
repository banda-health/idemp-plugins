package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTableIndex;

/**
 * Data Loader for AD_TableIndex - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TableIndexDataLoader extends PODataLoader<MTableIndex> {
	public static String AD_TableIndex_BY_ID_DATA_LOADER = "AD_TableIndexByIdDataLoader";
	public static String AD_TableIndex_BY_UUID_DATA_LOADER = "AD_TableIndexByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTableIndex.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_TableIndex_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_TableIndex_BY_UUID_DATA_LOADER;
	}
}
