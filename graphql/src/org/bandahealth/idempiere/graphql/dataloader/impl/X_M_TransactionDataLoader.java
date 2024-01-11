package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTransaction;

/**
 * Data Loader for M_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_TransactionDataLoader extends PODataLoader<MTransaction> {
	public static String M_Transaction_BY_ID_DATA_LOADER = "M_TransactionByIdDataLoader";
	public static String M_Transaction_BY_UUID_DATA_LOADER = "M_TransactionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTransaction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Transaction_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Transaction_BY_UUID_DATA_LOADER;
	}
}
