package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunningRunLine;

/**
 * Data Loader for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunLineDataLoader extends PODataLoader<MDunningRunLine> {
	public static String C_DunningRunLine_BY_ID_DATA_LOADER = "C_DunningRunLineByIdDataLoader";
	public static String C_DunningRunLine_BY_UUID_DATA_LOADER = "C_DunningRunLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunningRunLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_DunningRunLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_DunningRunLine_BY_UUID_DATA_LOADER;
	}
}
