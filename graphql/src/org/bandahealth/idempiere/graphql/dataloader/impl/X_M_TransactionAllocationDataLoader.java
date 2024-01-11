package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_TransactionAllocation;

/**
 * Data Loader for M_TransactionAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_TransactionAllocationDataLoader extends PODataLoader<X_M_TransactionAllocation> {
	public static String M_TransactionAllocation_BY_ID_DATA_LOADER = "M_TransactionAllocationByIdDataLoader";
	public static String M_TransactionAllocation_BY_UUID_DATA_LOADER = "M_TransactionAllocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_TransactionAllocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_TransactionAllocation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_TransactionAllocation_BY_UUID_DATA_LOADER;
	}
}
