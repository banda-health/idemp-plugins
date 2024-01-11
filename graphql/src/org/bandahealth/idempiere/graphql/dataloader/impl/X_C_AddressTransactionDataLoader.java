package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAddressTransaction;

/**
 * Data Loader for C_AddressTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AddressTransactionDataLoader extends PODataLoader<MAddressTransaction> {
	public static String C_AddressTransaction_BY_ID_DATA_LOADER = "C_AddressTransactionByIdDataLoader";
	public static String C_AddressTransaction_BY_UUID_DATA_LOADER = "C_AddressTransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAddressTransaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AddressTransaction_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AddressTransaction_BY_UUID_DATA_LOADER;
	}
}
