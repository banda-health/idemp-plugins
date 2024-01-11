package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaymentAllocate;

/**
 * Data Loader for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentAllocateDataLoader extends PODataLoader<MPaymentAllocate> {
	public static String C_PaymentAllocate_BY_ID_DATA_LOADER = "C_PaymentAllocateByIdDataLoader";
	public static String C_PaymentAllocate_BY_UUID_DATA_LOADER = "C_PaymentAllocateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaymentAllocate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaymentAllocate_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaymentAllocate_BY_UUID_DATA_LOADER;
	}
}
