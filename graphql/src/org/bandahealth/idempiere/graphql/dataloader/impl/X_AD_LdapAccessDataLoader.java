package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLdapAccess;

/**
 * Data Loader for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapAccessDataLoader extends PODataLoader<MLdapAccess> {
	public static String AD_LdapAccess_BY_ID_DATA_LOADER = "AD_LdapAccessByIdDataLoader";
	public static String AD_LdapAccess_BY_UUID_DATA_LOADER = "AD_LdapAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLdapAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_LdapAccess_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_LdapAccess_BY_UUID_DATA_LOADER;
	}
}
