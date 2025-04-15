package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPOSKey;

/**
 * Data Loader for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_POSKeyDataLoader extends PODataLoader<MPOSKey> {
	public static String DATALOADER_C_POSKey_BY_ID = "C_POSKeyByIdDataLoader";
	public static String DATALOADER_C_POSKey_BY_UUID = "C_POSKeyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPOSKey.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_POSKey_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_POSKey_BY_UUID;
	}
}
