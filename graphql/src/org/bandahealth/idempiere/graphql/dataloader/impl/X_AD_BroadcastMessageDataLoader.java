package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_BroadcastMessage;

/**
 * Data Loader for AD_BroadcastMessage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_BroadcastMessageDataLoader extends PODataLoader<X_AD_BroadcastMessage> {
	public static String AD_BroadcastMessage_BY_ID_DATA_LOADER = "AD_BroadcastMessageByIdDataLoader";
	public static String AD_BroadcastMessage_BY_UUID_DATA_LOADER = "AD_BroadcastMessageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_BroadcastMessage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_BroadcastMessage_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_BroadcastMessage_BY_UUID_DATA_LOADER;
	}
}
