package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MClientShare;

/**
 * Data Loader for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientShareDataLoader extends PODataLoader<MClientShare> {
	public static String AD_ClientShare_BY_ID_DATA_LOADER = "AD_ClientShareByIdDataLoader";
	public static String AD_ClientShare_BY_UUID_DATA_LOADER = "AD_ClientShareByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MClientShare.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ClientShare_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ClientShare_BY_UUID_DATA_LOADER;
	}
}
