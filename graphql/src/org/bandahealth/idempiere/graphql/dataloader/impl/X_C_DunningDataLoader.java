package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunning;

/**
 * Data Loader for C_Dunning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningDataLoader extends PODataLoader<MDunning> {
	public static String C_Dunning_BY_ID_DATA_LOADER = "C_DunningByIdDataLoader";
	public static String C_Dunning_BY_UUID_DATA_LOADER = "C_DunningByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunning.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Dunning_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Dunning_BY_UUID_DATA_LOADER;
	}
}
