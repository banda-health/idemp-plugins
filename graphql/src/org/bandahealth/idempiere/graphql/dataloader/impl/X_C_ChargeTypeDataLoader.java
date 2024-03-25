package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MChargeType_BH;

/**
 * Data Loader for C_ChargeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChargeTypeDataLoader extends PODataLoader<MChargeType_BH> {
	public static String DATALOADER_C_ChargeType_BY_ID = "C_ChargeTypeByIdDataLoader";
	public static String DATALOADER_C_ChargeType_BY_UUID = "C_ChargeTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChargeType_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ChargeType_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ChargeType_BY_UUID;
	}
}
