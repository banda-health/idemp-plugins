package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUOM;

/**
 * Data Loader for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_UOMDataLoader extends PODataLoader<MUOM> {
	public static String C_UOM_BY_ID_DATA_LOADER = "C_UOMByIdDataLoader";
	public static String C_UOM_BY_UUID_DATA_LOADER = "C_UOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_UOM_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_UOM_BY_UUID_DATA_LOADER;
	}
}
