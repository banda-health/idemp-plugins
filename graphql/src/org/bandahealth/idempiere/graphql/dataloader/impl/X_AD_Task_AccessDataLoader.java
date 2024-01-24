package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Task_Access;

/**
 * Data Loader for AD_Task_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Task_AccessDataLoader extends PODataLoader<X_AD_Task_Access> {
	public static String DATALOADER_AD_Task_Access_BY_ID = "AD_Task_AccessByIdDataLoader";
	public static String DATALOADER_AD_Task_Access_BY_UUID = "AD_Task_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Task_Access.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Task_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Task_Access_BY_UUID;
	}
}
