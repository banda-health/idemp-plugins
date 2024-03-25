package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MClient_BH;

/**
 * Data Loader for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ClientDataLoader extends PODataLoader<MClient_BH> {
	public static String DATALOADER_AD_Client_BY_ID = "AD_ClientByIdDataLoader";
	public static String DATALOADER_AD_Client_BY_UUID = "AD_ClientByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MClient_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Client_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Client_BY_UUID;
	}
}
