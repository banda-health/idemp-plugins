package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_BroadcastMessage;

/**
 * Data Loader for AD_BroadcastMessage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_BroadcastMessageDataLoader extends PODataLoader<X_AD_BroadcastMessage> {
	public static String DATALOADER_AD_BroadcastMessage_BY_ID = "AD_BroadcastMessageByIdDataLoader";
	public static String DATALOADER_AD_BroadcastMessage_BY_UUID = "AD_BroadcastMessageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_BroadcastMessage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_BroadcastMessage_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_BroadcastMessage_BY_UUID;
	}
}
