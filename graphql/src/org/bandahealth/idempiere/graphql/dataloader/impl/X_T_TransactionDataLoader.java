package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_Transaction;

/**
 * Data Loader for T_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_TransactionDataLoader extends PODataLoader<X_T_Transaction> {
	public static String DATALOADER_T_Transaction_BY_ID = "T_TransactionByIdDataLoader";
	public static String DATALOADER_T_Transaction_BY_UUID = "T_TransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_Transaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_Transaction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_Transaction_BY_UUID;
	}
}
