package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunningRun;

/**
 * Data Loader for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_DunningRunDataLoader extends PODataLoader<MDunningRun> {
	public static String DATALOADER_C_DunningRun_BY_ID = "C_DunningRunByIdDataLoader";
	public static String DATALOADER_C_DunningRun_BY_UUID = "C_DunningRunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunningRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_DunningRun_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_DunningRun_BY_UUID;
	}
}
