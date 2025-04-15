package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRMA;

/**
 * Data Loader for M_RMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_RMADataLoader extends PODataLoader<MRMA> {
	public static String DATALOADER_M_RMA_BY_ID = "M_RMAByIdDataLoader";
	public static String DATALOADER_M_RMA_BY_UUID = "M_RMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_RMA_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_RMA_BY_UUID;
	}
}
