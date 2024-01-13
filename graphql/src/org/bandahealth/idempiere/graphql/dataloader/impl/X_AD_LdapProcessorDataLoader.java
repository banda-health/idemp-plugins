package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLdapProcessor;

/**
 * Data Loader for AD_LdapProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapProcessorDataLoader extends PODataLoader<MLdapProcessor> {
	public static String DATALOADER_AD_LdapProcessor_BY_ID = "AD_LdapProcessorByIdDataLoader";
	public static String DATALOADER_AD_LdapProcessor_BY_UUID = "AD_LdapProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLdapProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_LdapProcessor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_LdapProcessor_BY_UUID;
	}
}
