package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;

/**
 * Data Loader for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Default_DocAction_AccessDataLoader extends PODataLoader<MBHDefaultDocActionAccess> {
	public static String BH_Default_DocAction_Access_BY_ID_DATA_LOADER = "BH_Default_DocAction_AccessByIdDataLoader";
	public static String BH_Default_DocAction_Access_BY_UUID_DATA_LOADER = "BH_Default_DocAction_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHDefaultDocActionAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Default_DocAction_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Default_DocAction_Access_BY_UUID_DATA_LOADER;
	}
}
