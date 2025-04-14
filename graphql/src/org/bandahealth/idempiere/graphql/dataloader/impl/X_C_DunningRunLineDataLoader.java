package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunningRunLine;

/**
 * Data Loader for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_DunningRunLineDataLoader extends PODataLoader<MDunningRunLine> {
	public static String DATALOADER_C_DunningRunLine_BY_ID = "C_DunningRunLineByIdDataLoader";
	public static String DATALOADER_C_DunningRunLine_BY_UUID = "C_DunningRunLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunningRunLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_DunningRunLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_DunningRunLine_BY_UUID;
	}
}
