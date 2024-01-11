package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBOM;

/**
 * Data Loader for M_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_BOMDataLoader extends PODataLoader<MBOM> {
	public static String M_BOM_BY_ID_DATA_LOADER = "M_BOMByIdDataLoader";
	public static String M_BOM_BY_UUID_DATA_LOADER = "M_BOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_BOM_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_BOM_BY_UUID_DATA_LOADER;
	}
}
