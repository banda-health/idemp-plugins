package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCashPlanLine;

/**
 * Data Loader for C_CashPlanLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CashPlanLineDataLoader extends PODataLoader<MCashPlanLine> {
	public static String DATALOADER_C_CashPlanLine_BY_ID = "C_CashPlanLineByIdDataLoader";
	public static String DATALOADER_C_CashPlanLine_BY_UUID = "C_CashPlanLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCashPlanLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CashPlanLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CashPlanLine_BY_UUID;
	}
}
