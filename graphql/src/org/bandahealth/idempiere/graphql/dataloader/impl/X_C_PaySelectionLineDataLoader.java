package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaySelectionLine;

/**
 * Data Loader for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaySelectionLineDataLoader extends PODataLoader<MPaySelectionLine> {
	public static String C_PaySelectionLine_BY_ID_DATA_LOADER = "C_PaySelectionLineByIdDataLoader";
	public static String C_PaySelectionLine_BY_UUID_DATA_LOADER = "C_PaySelectionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaySelectionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaySelectionLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaySelectionLine_BY_UUID_DATA_LOADER;
	}
}
