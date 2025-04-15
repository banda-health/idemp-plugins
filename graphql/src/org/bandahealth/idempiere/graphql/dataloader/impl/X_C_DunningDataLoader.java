package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunning;

/**
 * Data Loader for C_Dunning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DunningDataLoader extends PODataLoader<MDunning> {
	public static String DATALOADER_C_Dunning_BY_ID = "C_DunningByIdDataLoader";
	public static String DATALOADER_C_Dunning_BY_UUID = "C_DunningByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunning.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Dunning_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Dunning_BY_UUID;
	}
}
