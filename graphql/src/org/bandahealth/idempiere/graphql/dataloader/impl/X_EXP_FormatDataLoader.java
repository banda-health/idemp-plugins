package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEXPFormat;

/**
 * Data Loader for EXP_Format - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_FormatDataLoader extends PODataLoader<MEXPFormat> {
	public static String DATALOADER_EXP_Format_BY_ID = "EXP_FormatByIdDataLoader";
	public static String DATALOADER_EXP_Format_BY_UUID = "EXP_FormatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEXPFormat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_EXP_Format_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_EXP_Format_BY_UUID;
	}
}
