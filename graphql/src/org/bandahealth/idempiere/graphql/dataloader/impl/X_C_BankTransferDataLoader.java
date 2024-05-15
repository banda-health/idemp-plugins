package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankTransfer;

/**
 * Data Loader for C_BankTransfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankTransferDataLoader extends PODataLoader<MBankTransfer> {
	public static String DATALOADER_C_BankTransfer_BY_ID = "C_BankTransferByIdDataLoader";
	public static String DATALOADER_C_BankTransfer_BY_UUID = "C_BankTransferByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankTransfer.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BankTransfer_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BankTransfer_BY_UUID;
	}
}
