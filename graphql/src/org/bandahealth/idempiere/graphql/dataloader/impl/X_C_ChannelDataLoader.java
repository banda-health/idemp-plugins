package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Channel;

/**
 * Data Loader for C_Channel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChannelDataLoader extends PODataLoader<X_C_Channel> {
	public static String C_Channel_BY_ID_DATA_LOADER = "C_ChannelByIdDataLoader";
	public static String C_Channel_BY_UUID_DATA_LOADER = "C_ChannelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Channel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Channel_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Channel_BY_UUID_DATA_LOADER;
	}
}
