package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlertRecipient;

/**
 * Data Loader for AD_AlertRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AlertRecipientDataLoader extends PODataLoader<MAlertRecipient> {
	public static String DATALOADER_AD_AlertRecipient_BY_ID = "AD_AlertRecipientByIdDataLoader";
	public static String DATALOADER_AD_AlertRecipient_BY_UUID = "AD_AlertRecipientByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlertRecipient.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AlertRecipient_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AlertRecipient_BY_UUID;
	}
}
