package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaymentBatch;

/**
 * Data Loader for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentBatchDataLoader extends PODataLoader<MPaymentBatch> {
	public static String C_PaymentBatch_BY_ID_DATA_LOADER = "C_PaymentBatchByIdDataLoader";
	public static String C_PaymentBatch_BY_UUID_DATA_LOADER = "C_PaymentBatchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaymentBatch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaymentBatch_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaymentBatch_BY_UUID_DATA_LOADER;
	}
}
