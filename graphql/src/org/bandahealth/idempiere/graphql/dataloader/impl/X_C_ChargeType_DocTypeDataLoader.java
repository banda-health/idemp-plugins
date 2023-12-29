package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_ChargeType_DocType;

/**
 * Data Loader for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChargeType_DocTypeDataLoader extends PODataLoader<X_C_ChargeType_DocType> {
	public static String C_ChargeType_DocType_BY_ID_DATA_LOADER = "C_ChargeType_DocTypeByIdDataLoader";
	public static String C_ChargeType_DocType_BY_UUID_DATA_LOADER = "C_ChargeType_DocTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_ChargeType_DocType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ChargeType_DocType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ChargeType_DocType_BY_UUID_DATA_LOADER;
	}
}
