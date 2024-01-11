package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.M_Registration;

/**
 * Data Loader for AD_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RegistrationDataLoader extends PODataLoader<M_Registration> {
	public static String AD_Registration_BY_ID_DATA_LOADER = "AD_RegistrationByIdDataLoader";
	public static String AD_Registration_BY_UUID_DATA_LOADER = "AD_RegistrationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return M_Registration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Registration_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Registration_BY_UUID_DATA_LOADER;
	}
}
