package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Find;

/**
 * Data Loader for AD_Find - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_FindDataLoader extends PODataLoader<X_AD_Find> {
	public static String DATALOADER_AD_Find_BY_ID = "AD_FindByIdDataLoader";
	public static String DATALOADER_AD_Find_BY_UUID = "AD_FindByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Find.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Find_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Find_BY_UUID;
	}
}
