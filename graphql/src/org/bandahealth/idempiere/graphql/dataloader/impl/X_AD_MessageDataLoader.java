package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MMessage_BH;

/**
 * Data Loader for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_MessageDataLoader extends PODataLoader<MMessage_BH> {
	public static String DATALOADER_AD_Message_BY_ID = "AD_MessageByIdDataLoader";
	public static String DATALOADER_AD_Message_BY_UUID = "AD_MessageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMessage_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Message_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Message_BY_UUID;
	}
}
