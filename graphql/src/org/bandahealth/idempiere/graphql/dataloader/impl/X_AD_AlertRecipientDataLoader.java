package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAlertRecipient;

/**
 * Data Loader for AD_AlertRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertRecipientDataLoader extends PODataLoader<MAlertRecipient> {
	public static String AD_AlertRecipient_BY_ID_DATA_LOADER = "AD_AlertRecipientByIdDataLoader";
	public static String AD_AlertRecipient_BY_UUID_DATA_LOADER = "AD_AlertRecipientByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAlertRecipient.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_AlertRecipient_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_AlertRecipient_BY_UUID_DATA_LOADER;
	}
}
