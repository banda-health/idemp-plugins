package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MClientShare;

/**
 * Data Loader for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ClientShareDataLoader extends PODataLoader<MClientShare> {
	public static String DATALOADER_AD_ClientShare_BY_ID = "AD_ClientShareByIdDataLoader";
	public static String DATALOADER_AD_ClientShare_BY_UUID = "AD_ClientShareByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MClientShare.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ClientShare_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ClientShare_BY_UUID;
	}
}
