package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRMA;

/**
 * Data Loader for M_RMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RMADataLoader extends PODataLoader<MRMA> {
	public static String M_RMA_BY_ID_DATA_LOADER = "M_RMAByIdDataLoader";
	public static String M_RMA_BY_UUID_DATA_LOADER = "M_RMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_RMA_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_RMA_BY_UUID_DATA_LOADER;
	}
}
