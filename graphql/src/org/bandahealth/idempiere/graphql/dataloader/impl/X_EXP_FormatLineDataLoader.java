package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEXPFormatLine;

/**
 * Data Loader for EXP_FormatLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_EXP_FormatLineDataLoader extends PODataLoader<MEXPFormatLine> {
	public static String DATALOADER_EXP_FormatLine_BY_ID = "EXP_FormatLineByIdDataLoader";
	public static String DATALOADER_EXP_FormatLine_BY_UUID = "EXP_FormatLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEXPFormatLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_EXP_FormatLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_EXP_FormatLine_BY_UUID;
	}
}
