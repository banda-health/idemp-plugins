package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLdapProcessorLog;

/**
 * Data Loader for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LdapProcessorLogDataLoader extends PODataLoader<MLdapProcessorLog> {
	public static String DATALOADER_AD_LdapProcessorLog_BY_ID = "AD_LdapProcessorLogByIdDataLoader";
	public static String DATALOADER_AD_LdapProcessorLog_BY_UUID = "AD_LdapProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLdapProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_LdapProcessorLog_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_LdapProcessorLog_BY_UUID;
	}
}
