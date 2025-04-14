package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSchedulerRecipient;

/**
 * Data Loader for AD_SchedulerRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SchedulerRecipientDataLoader extends PODataLoader<MSchedulerRecipient> {
	public static String DATALOADER_AD_SchedulerRecipient_BY_ID = "AD_SchedulerRecipientByIdDataLoader";
	public static String DATALOADER_AD_SchedulerRecipient_BY_UUID = "AD_SchedulerRecipientByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSchedulerRecipient.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_SchedulerRecipient_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_SchedulerRecipient_BY_UUID;
	}
}
