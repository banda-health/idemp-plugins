package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;

/**
 * Data Loader for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_DefaultIncludedRoleDataLoader extends PODataLoader<MBHDefaultIncludedRole> {
	public static String DATALOADER_BH_DefaultIncludedRole_BY_ID = "BH_DefaultIncludedRoleByIdDataLoader";
	public static String DATALOADER_BH_DefaultIncludedRole_BY_UUID = "BH_DefaultIncludedRoleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHDefaultIncludedRole.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_DefaultIncludedRole_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_DefaultIncludedRole_BY_UUID;
	}
}
