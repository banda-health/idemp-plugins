package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MDocType_BH;

/**
 * Data Loader for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DocTypeDataLoader extends PODataLoader<MDocType_BH> {
	public static String DATALOADER_C_DocType_BY_ID = "C_DocTypeByIdDataLoader";
	public static String DATALOADER_C_DocType_BY_UUID = "C_DocTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDocType_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_DocType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_DocType_BY_UUID;
	}
}
