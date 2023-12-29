package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MChargeType_BH;

/**
 * Data Loader for C_ChargeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChargeTypeDataLoader extends PODataLoader<MChargeType_BH> {
	public static String C_ChargeType_BY_ID_DATA_LOADER = "C_ChargeTypeByIdDataLoader";
	public static String C_ChargeType_BY_UUID_DATA_LOADER = "C_ChargeTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChargeType_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ChargeType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ChargeType_BY_UUID_DATA_LOADER;
	}
}
