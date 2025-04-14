package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Role;

/**
 * Data Loader for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_RoleDataLoader extends PODataLoader<X_AD_Role> {
	public static String DATALOADER_AD_Role_BY_ID = "AD_RoleByIdDataLoader";
	public static String DATALOADER_AD_Role_BY_UUID = "AD_RoleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Role.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Role_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Role_BY_UUID;
	}
}
