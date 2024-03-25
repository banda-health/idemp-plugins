package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.M_Registration;

/**
 * Data Loader for AD_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RegistrationDataLoader extends PODataLoader<M_Registration> {
	public static String DATALOADER_AD_Registration_BY_ID = "AD_RegistrationByIdDataLoader";
	public static String DATALOADER_AD_Registration_BY_UUID = "AD_RegistrationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return M_Registration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Registration_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Registration_BY_UUID;
	}
}
