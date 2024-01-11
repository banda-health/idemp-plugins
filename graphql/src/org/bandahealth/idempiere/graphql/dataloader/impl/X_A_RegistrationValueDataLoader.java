package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRegistrationValue;

/**
 * Data Loader for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationValueDataLoader extends PODataLoader<MRegistrationValue> {
	public static String A_RegistrationValue_BY_ID_DATA_LOADER = "A_RegistrationValueByIdDataLoader";
	public static String A_RegistrationValue_BY_UUID_DATA_LOADER = "A_RegistrationValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRegistrationValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_RegistrationValue_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_RegistrationValue_BY_UUID_DATA_LOADER;
	}
}
