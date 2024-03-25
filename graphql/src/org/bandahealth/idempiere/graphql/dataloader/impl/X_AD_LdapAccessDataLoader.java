package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLdapAccess;

/**
 * Data Loader for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LdapAccessDataLoader extends PODataLoader<MLdapAccess> {
	public static String DATALOADER_AD_LdapAccess_BY_ID = "AD_LdapAccessByIdDataLoader";
	public static String DATALOADER_AD_LdapAccess_BY_UUID = "AD_LdapAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLdapAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_LdapAccess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_LdapAccess_BY_UUID;
	}
}
