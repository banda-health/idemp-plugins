package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlert;

/**
 * Data Loader for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertDataLoader extends PODataLoader<MAlert> {
	public static String AD_Alert_BY_ID_DATA_LOADER = "AD_AlertByIdDataLoader";
	public static String AD_Alert_BY_UUID_DATA_LOADER = "AD_AlertByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlert.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Alert_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Alert_BY_UUID_DATA_LOADER;
	}
}
