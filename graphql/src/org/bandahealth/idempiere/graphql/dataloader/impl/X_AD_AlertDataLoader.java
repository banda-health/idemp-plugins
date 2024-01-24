package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlert;

/**
 * Data Loader for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertDataLoader extends PODataLoader<MAlert> {
	public static String DATALOADER_AD_Alert_BY_ID = "AD_AlertByIdDataLoader";
	public static String DATALOADER_AD_Alert_BY_UUID = "AD_AlertByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlert.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Alert_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Alert_BY_UUID;
	}
}
