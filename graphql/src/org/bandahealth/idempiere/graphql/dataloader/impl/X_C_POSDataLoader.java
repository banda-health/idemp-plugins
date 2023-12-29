package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPOS;

/**
 * Data Loader for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSDataLoader extends PODataLoader<MPOS> {
	public static String C_POS_BY_ID_DATA_LOADER = "C_POSByIdDataLoader";
	public static String C_POS_BY_UUID_DATA_LOADER = "C_POSByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPOS.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_POS_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_POS_BY_UUID_DATA_LOADER;
	}
}
