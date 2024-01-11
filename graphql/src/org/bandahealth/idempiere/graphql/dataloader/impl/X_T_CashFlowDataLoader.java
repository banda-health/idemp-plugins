package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_CashFlow;

/**
 * Data Loader for T_CashFlow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_CashFlowDataLoader extends PODataLoader<X_T_CashFlow> {
	public static String T_CashFlow_BY_ID_DATA_LOADER = "T_CashFlowByIdDataLoader";
	public static String T_CashFlow_BY_UUID_DATA_LOADER = "T_CashFlowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_CashFlow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_CashFlow_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_CashFlow_BY_UUID_DATA_LOADER;
	}
}
