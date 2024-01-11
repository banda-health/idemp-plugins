package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSchedulerRecipient;

/**
 * Data Loader for AD_SchedulerRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SchedulerRecipientDataLoader extends PODataLoader<MSchedulerRecipient> {
	public static String AD_SchedulerRecipient_BY_ID_DATA_LOADER = "AD_SchedulerRecipientByIdDataLoader";
	public static String AD_SchedulerRecipient_BY_UUID_DATA_LOADER = "AD_SchedulerRecipientByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSchedulerRecipient.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_SchedulerRecipient_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_SchedulerRecipient_BY_UUID_DATA_LOADER;
	}
}
