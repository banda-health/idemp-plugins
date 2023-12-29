package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepositBatch;

/**
 * Data Loader for C_DepositBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DepositBatchDataLoader extends PODataLoader<MDepositBatch> {
	public static String C_DepositBatch_BY_ID_DATA_LOADER = "C_DepositBatchByIdDataLoader";
	public static String C_DepositBatch_BY_UUID_DATA_LOADER = "C_DepositBatchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepositBatch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_DepositBatch_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_DepositBatch_BY_UUID_DATA_LOADER;
	}
}
