package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MMessage_BH;

/**
 * Data Loader for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_MessageDataLoader extends PODataLoader<MMessage_BH> {
	public static String AD_Message_BY_ID_DATA_LOADER = "AD_MessageByIdDataLoader";
	public static String AD_Message_BY_UUID_DATA_LOADER = "AD_MessageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMessage_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Message_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Message_BY_UUID_DATA_LOADER;
	}
}
