package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaymentAllocate;

/**
 * Data Loader for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentAllocateDataLoader extends PODataLoader<MPaymentAllocate> {
	public static String DATALOADER_C_PaymentAllocate_BY_ID = "C_PaymentAllocateByIdDataLoader";
	public static String DATALOADER_C_PaymentAllocate_BY_UUID = "C_PaymentAllocateByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaymentAllocate.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_PaymentAllocate_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_PaymentAllocate_BY_UUID;
	}
}
