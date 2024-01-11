package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunningRun;

/**
 * Data Loader for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunDataLoader extends PODataLoader<MDunningRun> {
	public static String C_DunningRun_BY_ID_DATA_LOADER = "C_DunningRunByIdDataLoader";
	public static String C_DunningRun_BY_UUID_DATA_LOADER = "C_DunningRunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunningRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_DunningRun_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_DunningRun_BY_UUID_DATA_LOADER;
	}
}
