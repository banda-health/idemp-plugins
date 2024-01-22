package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MCharge_BH;

/**
 * Data Loader for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ChargeDataLoader extends PODataLoader<MCharge_BH> {
	public static String DATALOADER_C_Charge_BY_ID = "C_ChargeByIdDataLoader";
	public static String DATALOADER_C_Charge_BY_UUID = "C_ChargeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCharge_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Charge_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Charge_BY_UUID;
	}
}
