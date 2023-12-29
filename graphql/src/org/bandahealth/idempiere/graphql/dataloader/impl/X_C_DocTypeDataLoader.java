package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MDocType_BH;

/**
 * Data Loader for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DocTypeDataLoader extends PODataLoader<MDocType_BH> {
	public static String C_DocType_BY_ID_DATA_LOADER = "C_DocTypeByIdDataLoader";
	public static String C_DocType_BY_UUID_DATA_LOADER = "C_DocTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDocType_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_DocType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_DocType_BY_UUID_DATA_LOADER;
	}
}
