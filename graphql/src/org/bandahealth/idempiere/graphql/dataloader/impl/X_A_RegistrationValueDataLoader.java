package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRegistrationValue;

/**
 * Data Loader for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationValueDataLoader extends PODataLoader<MRegistrationValue> {
	public static String DATALOADER_A_RegistrationValue_BY_ID = "A_RegistrationValueByIdDataLoader";
	public static String DATALOADER_A_RegistrationValue_BY_UUID = "A_RegistrationValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRegistrationValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_RegistrationValue_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_RegistrationValue_BY_UUID;
	}
}
