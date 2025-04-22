package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDocTypeCounter;

/**
 * Data Loader for C_DocTypeCounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DocTypeCounterDataLoader extends PODataLoader<MDocTypeCounter> {
	public static String DATALOADER_C_DocTypeCounter_BY_ID = "C_DocTypeCounterByIdDataLoader";
	public static String DATALOADER_C_DocTypeCounter_BY_UUID = "C_DocTypeCounterByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDocTypeCounter.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_DocTypeCounter_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_DocTypeCounter_BY_UUID;
	}
}
