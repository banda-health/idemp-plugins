package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaymentBatch;

/**
 * Data Loader for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentBatchDataLoader extends PODataLoader<MPaymentBatch> {
	public static String DATALOADER_C_PaymentBatch_BY_ID = "C_PaymentBatchByIdDataLoader";
	public static String DATALOADER_C_PaymentBatch_BY_UUID = "C_PaymentBatchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaymentBatch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_PaymentBatch_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_PaymentBatch_BY_UUID;
	}
}
