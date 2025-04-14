package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBOM;

/**
 * Data Loader for M_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_BOMDataLoader extends PODataLoader<MBOM> {
	public static String DATALOADER_M_BOM_BY_ID = "M_BOMByIdDataLoader";
	public static String DATALOADER_M_BOM_BY_UUID = "M_BOMByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBOM.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_BOM_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_BOM_BY_UUID;
	}
}
