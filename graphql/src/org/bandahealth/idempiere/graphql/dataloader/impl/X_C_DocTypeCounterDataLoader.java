package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDocTypeCounter;

/**
 * Data Loader for C_DocTypeCounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DocTypeCounterDataLoader extends PODataLoader<MDocTypeCounter> {
	public static String C_DocTypeCounter_BY_ID_DATA_LOADER = "C_DocTypeCounterByIdDataLoader";
	public static String C_DocTypeCounter_BY_UUID_DATA_LOADER = "C_DocTypeCounterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDocTypeCounter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_DocTypeCounter_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_DocTypeCounter_BY_UUID_DATA_LOADER;
	}
}
