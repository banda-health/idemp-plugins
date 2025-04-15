package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepositBatch;

/**
 * Data Loader for C_DepositBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DepositBatchDataLoader extends PODataLoader<MDepositBatch> {
	public static String DATALOADER_C_DepositBatch_BY_ID = "C_DepositBatchByIdDataLoader";
	public static String DATALOADER_C_DepositBatch_BY_UUID = "C_DepositBatchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepositBatch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_DepositBatch_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_DepositBatch_BY_UUID;
	}
}
