package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Registration;

/**
 * Data Loader for A_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_RegistrationDataLoader extends PODataLoader<X_A_Registration> {
	public static String DATALOADER_A_Registration_BY_ID = "A_RegistrationByIdDataLoader";
	public static String DATALOADER_A_Registration_BY_UUID = "A_RegistrationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Registration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Registration_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Registration_BY_UUID;
	}
}
