package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepositBatchLine;

/**
 * Data Loader for C_DepositBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_DepositBatchLineDataLoader extends PODataLoader<MDepositBatchLine> {
	public static String DATALOADER_C_DepositBatchLine_BY_ID = "C_DepositBatchLineByIdDataLoader";
	public static String DATALOADER_C_DepositBatchLine_BY_UUID = "C_DepositBatchLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepositBatchLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_DepositBatchLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_DepositBatchLine_BY_UUID;
	}
}
