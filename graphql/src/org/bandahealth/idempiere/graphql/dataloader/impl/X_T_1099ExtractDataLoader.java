package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_1099Extract;

/**
 * Data Loader for T_1099Extract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_1099ExtractDataLoader extends PODataLoader<X_T_1099Extract> {
	public static String DATALOADER_T_1099Extract_BY_ID = "T_1099ExtractByIdDataLoader";
	public static String DATALOADER_T_1099Extract_BY_UUID = "T_1099ExtractByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_1099Extract.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_1099Extract_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_1099Extract_BY_UUID;
	}
}
