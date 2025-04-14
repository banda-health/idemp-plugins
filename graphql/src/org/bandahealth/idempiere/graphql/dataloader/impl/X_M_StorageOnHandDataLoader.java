package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStorageOnHand;

/**
 * Data Loader for M_StorageOnHand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_StorageOnHandDataLoader extends PODataLoader<MStorageOnHand> {
	public static String DATALOADER_M_StorageOnHand_BY_ID = "M_StorageOnHandByIdDataLoader";
	public static String DATALOADER_M_StorageOnHand_BY_UUID = "M_StorageOnHandByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStorageOnHand.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_StorageOnHand_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_StorageOnHand_BY_UUID;
	}
}
