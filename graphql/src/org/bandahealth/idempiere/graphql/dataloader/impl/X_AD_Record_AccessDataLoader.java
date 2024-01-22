package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRecordAccess;

/**
 * Data Loader for AD_Record_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Record_AccessDataLoader extends PODataLoader<MRecordAccess> {
	public static String DATALOADER_AD_Record_Access_BY_ID = "AD_Record_AccessByIdDataLoader";
	public static String DATALOADER_AD_Record_Access_BY_UUID = "AD_Record_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRecordAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Record_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Record_Access_BY_UUID;
	}
}
