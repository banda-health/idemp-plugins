package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Role;

/**
 * Data Loader for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RoleDataLoader extends PODataLoader<X_AD_Role> {
	public static String AD_Role_BY_ID_DATA_LOADER = "AD_RoleByIdDataLoader";
	public static String AD_Role_BY_UUID_DATA_LOADER = "AD_RoleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Role.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Role_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Role_BY_UUID_DATA_LOADER;
	}
}
