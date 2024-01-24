package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAddressTransaction;

/**
 * Data Loader for C_AddressTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AddressTransactionDataLoader extends PODataLoader<MAddressTransaction> {
	public static String DATALOADER_C_AddressTransaction_BY_ID = "C_AddressTransactionByIdDataLoader";
	public static String DATALOADER_C_AddressTransaction_BY_UUID = "C_AddressTransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAddressTransaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_AddressTransaction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_AddressTransaction_BY_UUID;
	}
}
