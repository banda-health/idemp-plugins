package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_TransactionAllocation;

/**
 * Data Loader for M_TransactionAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_TransactionAllocationDataLoader extends PODataLoader<X_M_TransactionAllocation> {
	public static String DATALOADER_M_TransactionAllocation_BY_ID = "M_TransactionAllocationByIdDataLoader";
	public static String DATALOADER_M_TransactionAllocation_BY_UUID = "M_TransactionAllocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_TransactionAllocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_TransactionAllocation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_TransactionAllocation_BY_UUID;
	}
}
