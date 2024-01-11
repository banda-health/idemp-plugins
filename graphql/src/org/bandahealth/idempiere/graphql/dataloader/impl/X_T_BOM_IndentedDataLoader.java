package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_BOM_Indented;

/**
 * Data Loader for T_BOM_Indented - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_BOM_IndentedDataLoader extends PODataLoader<X_T_BOM_Indented> {
	public static String T_BOM_Indented_BY_ID_DATA_LOADER = "T_BOM_IndentedByIdDataLoader";
	public static String T_BOM_Indented_BY_UUID_DATA_LOADER = "T_BOM_IndentedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_BOM_Indented.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_BOM_Indented_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_BOM_Indented_BY_UUID_DATA_LOADER;
	}
}
