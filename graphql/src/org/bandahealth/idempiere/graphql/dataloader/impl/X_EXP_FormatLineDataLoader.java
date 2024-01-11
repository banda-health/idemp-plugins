package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEXPFormatLine;

/**
 * Data Loader for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_FormatLineDataLoader extends PODataLoader<MEXPFormatLine> {
	public static String EXP_FormatLine_BY_ID_DATA_LOADER = "EXP_FormatLineByIdDataLoader";
	public static String EXP_FormatLine_BY_UUID_DATA_LOADER = "EXP_FormatLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEXPFormatLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return EXP_FormatLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return EXP_FormatLine_BY_UUID_DATA_LOADER;
	}
}
