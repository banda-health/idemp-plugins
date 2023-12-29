package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MCharge_BH;

/**
 * Data Loader for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChargeDataLoader extends PODataLoader<MCharge_BH> {
	public static String C_Charge_BY_ID_DATA_LOADER = "C_ChargeByIdDataLoader";
	public static String C_Charge_BY_UUID_DATA_LOADER = "C_ChargeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCharge_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Charge_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Charge_BY_UUID_DATA_LOADER;
	}
}
