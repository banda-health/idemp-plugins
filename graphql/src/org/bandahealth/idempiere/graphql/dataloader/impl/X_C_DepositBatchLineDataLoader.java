package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepositBatchLine;

/**
 * Data Loader for C_DepositBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DepositBatchLineDataLoader extends PODataLoader<MDepositBatchLine> {
	public static String C_DepositBatchLine_BY_ID_DATA_LOADER = "C_DepositBatchLineByIdDataLoader";
	public static String C_DepositBatchLine_BY_UUID_DATA_LOADER = "C_DepositBatchLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepositBatchLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_DepositBatchLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_DepositBatchLine_BY_UUID_DATA_LOADER;
	}
}
