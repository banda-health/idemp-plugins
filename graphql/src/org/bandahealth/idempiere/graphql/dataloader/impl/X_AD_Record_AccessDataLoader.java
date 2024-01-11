package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRecordAccess;

/**
 * Data Loader for AD_Record_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Record_AccessDataLoader extends PODataLoader<MRecordAccess> {
	public static String AD_Record_Access_BY_ID_DATA_LOADER = "AD_Record_AccessByIdDataLoader";
	public static String AD_Record_Access_BY_UUID_DATA_LOADER = "AD_Record_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRecordAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Record_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Record_Access_BY_UUID_DATA_LOADER;
	}
}
