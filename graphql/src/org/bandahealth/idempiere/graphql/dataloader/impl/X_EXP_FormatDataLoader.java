package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MEXPFormat;

/**
 * Data Loader for EXP_Format - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_FormatDataLoader extends PODataLoader<MEXPFormat> {
	public static String EXP_Format_BY_ID_DATA_LOADER = "EXP_FormatByIdDataLoader";
	public static String EXP_Format_BY_UUID_DATA_LOADER = "EXP_FormatByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MEXPFormat.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return EXP_Format_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return EXP_Format_BY_UUID_DATA_LOADER;
	}
}
