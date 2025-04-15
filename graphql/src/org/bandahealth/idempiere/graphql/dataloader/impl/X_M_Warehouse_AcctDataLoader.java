package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Warehouse_Acct;

/**
 * Data Loader for M_Warehouse_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_Warehouse_AcctDataLoader extends PODataLoader<X_M_Warehouse_Acct> {
	public static String DATALOADER_M_Warehouse_Acct_BY_ID = "M_Warehouse_AcctByIdDataLoader";
	public static String DATALOADER_M_Warehouse_Acct_BY_UUID = "M_Warehouse_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Warehouse_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Warehouse_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Warehouse_Acct_BY_UUID;
	}
}
