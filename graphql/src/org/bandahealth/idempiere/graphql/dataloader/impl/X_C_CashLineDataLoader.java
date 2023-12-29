package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCashLine;

/**
 * Data Loader for C_CashLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashLineDataLoader extends PODataLoader<MCashLine> {
	public static String C_CashLine_BY_ID_DATA_LOADER = "C_CashLineByIdDataLoader";
	public static String C_CashLine_BY_UUID_DATA_LOADER = "C_CashLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCashLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CashLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CashLine_BY_UUID_DATA_LOADER;
	}
}
