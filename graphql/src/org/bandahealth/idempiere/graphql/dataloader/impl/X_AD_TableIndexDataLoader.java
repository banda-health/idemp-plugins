package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTableIndex;

/**
 * Data Loader for AD_TableIndex - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TableIndexDataLoader extends PODataLoader<MTableIndex> {
	public static String DATALOADER_AD_TableIndex_BY_ID = "AD_TableIndexByIdDataLoader";
	public static String DATALOADER_AD_TableIndex_BY_UUID = "AD_TableIndexByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTableIndex.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_TableIndex_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_TableIndex_BY_UUID;
	}
}
