package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSystem;

/**
 * Data Loader for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SystemDataLoader extends PODataLoader<MSystem> {
	public static String DATALOADER_AD_System_BY_ID = "AD_SystemByIdDataLoader";
	public static String DATALOADER_AD_System_BY_UUID = "AD_SystemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSystem.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_System_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_System_BY_UUID;
	}
}
