package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStorageOnHand;

/**
 * Data Loader for M_StorageOnHand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_StorageOnHandDataLoader extends PODataLoader<MStorageOnHand> {
	public static String M_StorageOnHand_BY_ID_DATA_LOADER = "M_StorageOnHandByIdDataLoader";
	public static String M_StorageOnHand_BY_UUID_DATA_LOADER = "M_StorageOnHandByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStorageOnHand.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_StorageOnHand_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_StorageOnHand_BY_UUID_DATA_LOADER;
	}
}
