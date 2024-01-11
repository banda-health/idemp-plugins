package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPOSKey;

/**
 * Data Loader for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSKeyDataLoader extends PODataLoader<MPOSKey> {
	public static String C_POSKey_BY_ID_DATA_LOADER = "C_POSKeyByIdDataLoader";
	public static String C_POSKey_BY_UUID_DATA_LOADER = "C_POSKeyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPOSKey.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_POSKey_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_POSKey_BY_UUID_DATA_LOADER;
	}
}
