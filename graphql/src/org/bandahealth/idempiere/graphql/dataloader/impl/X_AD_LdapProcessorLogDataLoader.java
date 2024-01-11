package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLdapProcessorLog;

/**
 * Data Loader for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapProcessorLogDataLoader extends PODataLoader<MLdapProcessorLog> {
	public static String AD_LdapProcessorLog_BY_ID_DATA_LOADER = "AD_LdapProcessorLogByIdDataLoader";
	public static String AD_LdapProcessorLog_BY_UUID_DATA_LOADER = "AD_LdapProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLdapProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_LdapProcessorLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_LdapProcessorLog_BY_UUID_DATA_LOADER;
	}
}
