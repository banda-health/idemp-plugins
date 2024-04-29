package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_BOM_Indented;

/**
 * Data Loader for T_BOM_Indented - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_BOM_IndentedDataLoader extends PODataLoader<X_T_BOM_Indented> {
	public static String DATALOADER_T_BOM_Indented_BY_ID = "T_BOM_IndentedByIdDataLoader";
	public static String DATALOADER_T_BOM_Indented_BY_UUID = "T_BOM_IndentedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_BOM_Indented.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_BOM_Indented_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_BOM_Indented_BY_UUID;
	}
}
