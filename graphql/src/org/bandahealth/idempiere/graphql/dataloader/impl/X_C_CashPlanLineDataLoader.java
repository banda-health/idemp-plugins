package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCashPlanLine;

/**
 * Data Loader for C_CashPlanLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashPlanLineDataLoader extends PODataLoader<MCashPlanLine> {
	public static String C_CashPlanLine_BY_ID_DATA_LOADER = "C_CashPlanLineByIdDataLoader";
	public static String C_CashPlanLine_BY_UUID_DATA_LOADER = "C_CashPlanLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCashPlanLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CashPlanLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CashPlanLine_BY_UUID_DATA_LOADER;
	}
}
