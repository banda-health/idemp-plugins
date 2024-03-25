package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUOM;

/**
 * Data Loader for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_UOMDataLoader extends PODataLoader<MUOM> {
	public static String DATALOADER_C_UOM_BY_ID = "C_UOMByIdDataLoader";
	public static String DATALOADER_C_UOM_BY_UUID = "C_UOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_UOM_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_UOM_BY_UUID;
	}
}
