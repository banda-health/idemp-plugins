package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRegistration;

/**
 * Data Loader for A_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationDataLoader extends PODataLoader<MRegistration> {
	public static String A_Registration_BY_ID_DATA_LOADER = "A_RegistrationByIdDataLoader";
	public static String A_Registration_BY_UUID_DATA_LOADER = "A_RegistrationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRegistration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Registration_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Registration_BY_UUID_DATA_LOADER;
	}
}
