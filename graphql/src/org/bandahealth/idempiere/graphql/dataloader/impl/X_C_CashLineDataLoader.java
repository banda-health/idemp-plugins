package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCashLine;

/**
 * Data Loader for C_CashLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CashLineDataLoader extends PODataLoader<MCashLine> {
	public static String DATALOADER_C_CashLine_BY_ID = "C_CashLineByIdDataLoader";
	public static String DATALOADER_C_CashLine_BY_UUID = "C_CashLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCashLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CashLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CashLine_BY_UUID;
	}
}
