package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTransaction;

/**
 * Data Loader for M_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_TransactionDataLoader extends PODataLoader<MTransaction> {
	public static String DATALOADER_M_Transaction_BY_ID = "M_TransactionByIdDataLoader";
	public static String DATALOADER_M_Transaction_BY_UUID = "M_TransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTransaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Transaction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Transaction_BY_UUID;
	}
}
