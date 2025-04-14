package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_CashFlow;

/**
 * Data Loader for T_CashFlow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_T_CashFlowDataLoader extends PODataLoader<X_T_CashFlow> {
	public static String DATALOADER_T_CashFlow_BY_ID = "T_CashFlowByIdDataLoader";
	public static String DATALOADER_T_CashFlow_BY_UUID = "T_CashFlowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_CashFlow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_CashFlow_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_CashFlow_BY_UUID;
	}
}
