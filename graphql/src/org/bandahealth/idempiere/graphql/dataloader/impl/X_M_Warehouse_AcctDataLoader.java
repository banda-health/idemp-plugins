package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Warehouse_Acct;

/**
 * Data Loader for M_Warehouse_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Warehouse_AcctDataLoader extends PODataLoader<X_M_Warehouse_Acct> {
	public static String M_Warehouse_Acct_BY_ID_DATA_LOADER = "M_Warehouse_AcctByIdDataLoader";
	public static String M_Warehouse_Acct_BY_UUID_DATA_LOADER = "M_Warehouse_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Warehouse_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Warehouse_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Warehouse_Acct_BY_UUID_DATA_LOADER;
	}
}
