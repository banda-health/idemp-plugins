package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MClient_BH;

/**
 * Data Loader for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientDataLoader extends PODataLoader<MClient_BH> {
	public static String AD_Client_BY_ID_DATA_LOADER = "AD_ClientByIdDataLoader";
	public static String AD_Client_BY_UUID_DATA_LOADER = "AD_ClientByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MClient_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Client_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Client_BY_UUID_DATA_LOADER;
	}
}
