package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTableAccess;

/**
 * Data Loader for AD_Table_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Table_AccessDataLoader extends PODataLoader<MTableAccess> {
	public static String DATALOADER_AD_Table_Access_BY_ID = "AD_Table_AccessByIdDataLoader";
	public static String DATALOADER_AD_Table_Access_BY_UUID = "AD_Table_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTableAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Table_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Table_Access_BY_UUID;
	}
}
