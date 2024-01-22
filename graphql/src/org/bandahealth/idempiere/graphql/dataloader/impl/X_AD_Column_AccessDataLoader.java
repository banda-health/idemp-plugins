package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MColumnAccess;

/**
 * Data Loader for AD_Column_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Column_AccessDataLoader extends PODataLoader<MColumnAccess> {
	public static String DATALOADER_AD_Column_Access_BY_ID = "AD_Column_AccessByIdDataLoader";
	public static String DATALOADER_AD_Column_Access_BY_UUID = "AD_Column_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MColumnAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Column_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Column_Access_BY_UUID;
	}
}
