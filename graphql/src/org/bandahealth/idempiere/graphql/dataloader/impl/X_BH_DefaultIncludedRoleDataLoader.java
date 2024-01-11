package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;

/**
 * Data Loader for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_DefaultIncludedRoleDataLoader extends PODataLoader<MBHDefaultIncludedRole> {
	public static String BH_DefaultIncludedRole_BY_ID_DATA_LOADER = "BH_DefaultIncludedRoleByIdDataLoader";
	public static String BH_DefaultIncludedRole_BY_UUID_DATA_LOADER = "BH_DefaultIncludedRoleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHDefaultIncludedRole.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_DefaultIncludedRole_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_DefaultIncludedRole_BY_UUID_DATA_LOADER;
	}
}
